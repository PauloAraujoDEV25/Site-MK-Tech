# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests -q

# Copiar o JAR executável (prioriza app.jar, depois qualquer .jar na pasta)
RUN if [ -f target/app.jar ]; then cp target/app.jar /tmp/app.jar; else cp target/*.jar /tmp/app.jar 2>/dev/null || exit 1; fi && ls -lh /tmp/app.jar

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR
COPY --from=builder /tmp/app.jar .

# Expor porta
EXPOSE 8080

# Definir defaults
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8080

# Script de entrada para garantir expansão de variáveis
RUN echo '#!/bin/sh' > /app/entrypoint.sh && \
    echo 'exec java -Dserver.port=${PORT:-8080} -jar app.jar' >> /app/entrypoint.sh && \
    chmod +x /app/entrypoint.sh

# Comando para iniciar
ENTRYPOINT ["/app/entrypoint.sh"]
