param(
    [Parameter(Mandatory = $false)]
    [string]$InputPath = "src/main/resources/static/Cozinha moderna com toque aconchegante.png",

    [Parameter(Mandatory = $false)]
    [string]$OutputPath = "src/main/resources/static/Cozinha moderna com toque aconchegante@2x.png",

    [Parameter(Mandatory = $false)]
    [int]$Scale = 2,

    [Parameter(Mandatory = $false)]
    [int]$TargetWidth = 0,

    [Parameter(Mandatory = $false)]
    [int]$TargetHeight = 0,

    [Parameter(Mandatory = $false)]
    [string]$LogPath = "tools/upscale-hero.log",

    [Parameter(Mandatory = $false)]
    [switch]$NoSharpen
)

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

try {
    $logDir = Split-Path $LogPath -Parent
    if ($logDir -and -not (Test-Path $logDir)) {
        New-Item -ItemType Directory -Path $logDir | Out-Null
    }
    "Start: $(Get-Date -Format o)" | Set-Content -Encoding UTF8 $LogPath
    "InputPath: $InputPath" | Add-Content -Encoding UTF8 $LogPath
    "OutputPath: $OutputPath" | Add-Content -Encoding UTF8 $LogPath
    "Scale: $Scale; TargetWidth: $TargetWidth; TargetHeight: $TargetHeight; NoSharpen: $NoSharpen" | Add-Content -Encoding UTF8 $LogPath
}
catch {
    # Logging should never prevent processing
}

trap {
    try {
        "ERROR: $($_.Exception.GetType().FullName)" | Add-Content -Encoding UTF8 $LogPath
        ($_.Exception.Message | Out-String).TrimEnd() | Add-Content -Encoding UTF8 $LogPath
        ($_.ScriptStackTrace | Out-String).TrimEnd() | Add-Content -Encoding UTF8 $LogPath
    }
    catch {}
    break
}

if (-not (Test-Path $InputPath)) {
    throw "Input image not found: $InputPath"
}

Add-Type -AssemblyName System.Drawing

function Log-Line([string]$line) {
    try { $line | Add-Content -Encoding UTF8 $LogPath } catch {}
}

function Clamp-Byte([int]$value) {
    if ($value -lt 0) { return 0 }
    if ($value -gt 255) { return 255 }
    return [byte]$value
}

function Apply-SharpenKernel {
    param(
        [Parameter(Mandatory = $true)]
        [System.Drawing.Bitmap]$Bitmap
    )

    $width = $Bitmap.Width
    $height = $Bitmap.Height

    $rect = New-Object System.Drawing.Rectangle(0, 0, $width, $height)
    $pixelFormat = [System.Drawing.Imaging.PixelFormat]::Format32bppArgb

    $src = $Bitmap.Clone($rect, $pixelFormat)
    $dst = New-Object System.Drawing.Bitmap($width, $height, $pixelFormat)

    $srcData = $src.LockBits($rect, [System.Drawing.Imaging.ImageLockMode]::ReadOnly, $pixelFormat)
    $dstData = $dst.LockBits($rect, [System.Drawing.Imaging.ImageLockMode]::WriteOnly, $pixelFormat)

    try {
        $bytes = [Math]::Abs($srcData.Stride) * $height
        $srcBuffer = New-Object byte[] $bytes
        $dstBuffer = New-Object byte[] $bytes

        [System.Runtime.InteropServices.Marshal]::Copy($srcData.Scan0, $srcBuffer, 0, $bytes)

        # Kernel: 0 -1  0
        #        -1  5 -1
        #         0 -1  0
        $k = @(0, -1, 0, -1, 5, -1, 0, -1, 0)

        $stride = $srcData.Stride

        # Copy original first (so borders stay intact)
        [Array]::Copy($srcBuffer, $dstBuffer, $bytes)

        for ($y = 1; $y -lt ($height - 1); $y++) {
            $row = $y * $stride
            for ($x = 1; $x -lt ($width - 1); $x++) {
                $idx = $row + ($x * 4)

                $sumB = 0
                $sumG = 0
                $sumR = 0

                $kIndex = 0
                for ($ky = -1; $ky -le 1; $ky++) {
                    $kRow = ($y + $ky) * $stride
                    for ($kx = -1; $kx -le 1; $kx++) {
                        $p = $kRow + (($x + $kx) * 4)
                        $weight = $k[$kIndex]

                        $sumB += $weight * $srcBuffer[$p + 0]
                        $sumG += $weight * $srcBuffer[$p + 1]
                        $sumR += $weight * $srcBuffer[$p + 2]

                        $kIndex++
                    }
                }

                $dstBuffer[$idx + 0] = Clamp-Byte $sumB
                $dstBuffer[$idx + 1] = Clamp-Byte $sumG
                $dstBuffer[$idx + 2] = Clamp-Byte $sumR
                # Preserve alpha from original
                $dstBuffer[$idx + 3] = $srcBuffer[$idx + 3]
            }
        }

        [System.Runtime.InteropServices.Marshal]::Copy($dstBuffer, 0, $dstData.Scan0, $bytes)
    }
    finally {
        $src.UnlockBits($srcData)
        $dst.UnlockBits($dstData)
        $src.Dispose()
    }

    return $dst
}

$resolvedInput = (Resolve-Path $InputPath)
Log-Line "ResolvedInput: $resolvedInput"

$img = [System.Drawing.Image]::FromFile($resolvedInput)
try {
    Log-Line ("Loaded: {0}x{1}" -f $img.Width, $img.Height)
    if ($TargetWidth -gt 0 -and $TargetHeight -gt 0) {
        $newWidth = [int]$TargetWidth
        $newHeight = [int]$TargetHeight
    }
    elseif ($TargetWidth -gt 0) {
        $newWidth = [int]$TargetWidth
        $newHeight = [int][Math]::Round($newWidth * ($img.Height / [double]$img.Width))
    }
    elseif ($TargetHeight -gt 0) {
        $newHeight = [int]$TargetHeight
        $newWidth = [int][Math]::Round($newHeight * ($img.Width / [double]$img.Height))
    }
    else {
        $newWidth = [int]($img.Width * $Scale)
        $newHeight = [int]($img.Height * $Scale)
    }

    Log-Line ("Target: {0}x{1}" -f $newWidth, $newHeight)

    Log-Line "Alloc bitmap..."
    $resized = New-Object System.Drawing.Bitmap($newWidth, $newHeight, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    Log-Line "Alloc bitmap OK"
    $g = [System.Drawing.Graphics]::FromImage($resized)

    try {
        $g.CompositingMode = [System.Drawing.Drawing2D.CompositingMode]::SourceCopy
        $g.CompositingQuality = [System.Drawing.Drawing2D.CompositingQuality]::HighQuality
        $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
        $g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::HighQuality
        $g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality

        Log-Line "Draw..."
        $g.DrawImage($img, 0, 0, $newWidth, $newHeight)
        Log-Line "Draw OK"
    }
    finally {
        $g.Dispose()
    }

    $final = $resized
    if (-not $NoSharpen) {
        Log-Line "Sharpen..."
        $final = Apply-SharpenKernel -Bitmap $resized
        $resized.Dispose()
        Log-Line "Sharpen OK"
    }

    $outFull = Join-Path (Get-Location) $OutputPath
    $outDir = Split-Path $outFull -Parent
    if (-not (Test-Path $outDir)) {
        New-Item -ItemType Directory -Path $outDir | Out-Null
    }

    Log-Line "Save..."
    $final.Save($outFull, [System.Drawing.Imaging.ImageFormat]::Png)
    Log-Line "Save OK"

    try {
        "Created: $OutputPath ($newWidth x $newHeight)" | Add-Content -Encoding UTF8 $LogPath
    }
    catch {}

    "Created: $OutputPath ($newWidth x $newHeight)" | Write-Output
}
finally {
    $img.Dispose()
}
