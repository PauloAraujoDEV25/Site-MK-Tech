# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests -q

# Copiar o JAR executável
RUN if [ -f target/app.jar ]; then cp target/app.jar /tmp/app.jar; else cp target/*.jar /tmp/app.jar 2>/dev/null || exit 1; fi

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR
COPY --from=builder /tmp/app.jar .

# Expor porta
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "app.jar"]
