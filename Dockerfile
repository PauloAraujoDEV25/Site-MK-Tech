# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação com verbose
RUN mvn clean package -DskipTests -X && echo "=== JAR Files ===" && find target -name "*.jar" -type f

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar qualquer JAR do build
COPY --from=builder /app/target/*.jar app.jar || true

# Verificar se JAR existe
RUN ls -la /app/

# Expor porta
EXPOSE 8080

# Definir profile de produção
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para iniciar
CMD ["java", "-jar", "app.jar"]
