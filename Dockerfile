# Dockerfile para Railway
FROM maven:3.8-openjdk-21 AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-slim

WORKDIR /app

# Copiar JAR do build anterior
COPY --from=builder /app/target/Site-MK-Tech-1.0-SNAPSHOT.jar app.jar

# Expor porta
EXPOSE 8080

# Definir profile de produção
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
