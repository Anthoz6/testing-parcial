# Imagen base ligera de Java
FROM eclipse-temurin:21-jre-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el .jar compilado desde tu máquina al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto donde corre la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
