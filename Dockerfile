# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build com output visível
RUN mvn clean package -DskipTests && \
    echo "======================================" && \
    echo "BUILD COMPLETE - Contents of target:" && \
    echo "======================================" && \
    ls -lah target/ && \
    echo "" && \
    echo "JAR files found:" && \
    find target -name "*.jar" -exec ls -lh {} \; && \
    echo "" && \
    echo "Copying to /app/app.jar..." && \
    cp target/app.jar /app/ || cp target/app*.jar /app/app.jar

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar JAR
COPY --from=builder /app/app.jar .

# Expor porta
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "app.jar"]
