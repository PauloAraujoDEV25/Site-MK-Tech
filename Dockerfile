# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar JAR do build anterior
COPY --from=builder /app/target/*.jar app.jar

# Expor porta
EXPOSE 8080

# Definir profile de produção
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
