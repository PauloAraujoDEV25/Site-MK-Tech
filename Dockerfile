# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests -q

# Debug: listar o que foi gerado
RUN echo "=== Build output ===" && \
    ls -la target/ && \
    echo "=== JAR files ===" && \
    find target -name "*.jar" -type f && \
    echo "=== Renaming app.jar if needed ===" && \
    (test -f target/app.jar && echo "app.jar found" || (ls target/*.jar && cp target/app*.jar target/app.jar 2>/dev/null || echo "No JAR found"))

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR gerado
COPY --from=builder /app/target/app.jar .

# Verificar que existe
RUN test -f /app/app.jar && echo "JAR copied successfully" || exit 1

# Expor porta
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "app.jar"]
