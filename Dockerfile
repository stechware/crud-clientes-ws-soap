# ===============================
# Etapa 1: Compilación con Maven
# ===============================
FROM maven:3.9.9-eclipse-temurin-8 AS build

# Crear el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias primero (para cacheo)
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copiar todo el código fuente del proyecto
COPY src ./src

# Compilar el proyecto y generar el WAR (sin ejecutar tests)
RUN mvn clean package -DskipTests

# ===============================
# Etapa 2: Despliegue con Tomcat
# ===============================
FROM tomcat:8.5-jdk8

# Limpiar aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el WAR generado desde la etapa anterior
COPY --from=build /app/target/CrudClienteWs.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto
EXPOSE 8080

# Comando de inicio
CMD ["catalina.sh", "run"]

