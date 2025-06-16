# Usa una imagen oficial de Java
FROM eclipse-temurin:17

# Crea un directorio de trabajo
WORKDIR /app

# Copia todo el contenido del repo
COPY . .

# Da permisos por si usas mvnw
RUN chmod +x mvnw

# Compila la aplicación
RUN ./mvnw clean install

# Comando para arrancar la app
CMD ["java", "-jar", "target/Invitation-service-1.0.jar"]
