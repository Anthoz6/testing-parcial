# Etapa 1: construir con Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar pom.xml y dependencias primero (para aprovechar la cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Luego copiar el código fuente
COPY src ./src

# Compilar el proyecto (sin tests para ahorrar tiempo)
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar la aplicación con una imagen ligera
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el jar compilado desde la etapa anterior
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
