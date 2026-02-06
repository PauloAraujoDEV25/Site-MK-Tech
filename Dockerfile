# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests -q && ls -la target/ && ls -la target/*.jar

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar QUALQUER jar gerado (o único que vai estar lá é o executável)
COPY --from=builder /app/target/*.jar app.jar

# Listar para debug
RUN ls -la /app/

# Expor porta
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "app.jar"]
