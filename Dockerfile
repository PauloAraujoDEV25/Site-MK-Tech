# Dockerfile para Railway
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests

# Liste todos os JARs para debug
RUN find /app/target -name "*.jar" -type f

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR executável (que tem .jar.original e .jar)
COPY --from=builder /app/target/app.jar .

# Expor porta
EXPOSE 8080

# Definir profile de produção
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para iniciar com shell para resolver ${PORT}
CMD java -Dserver.port=${PORT:-8080} -jar /app/app.jar
