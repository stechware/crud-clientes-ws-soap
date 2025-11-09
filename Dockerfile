# Etapa 1: compilar con Maven
FROM maven:3.8.7-jdk-8 AS build

# Copiar el código fuente
COPY . /app
WORKDIR /app

# Compilar el proyecto y generar el WAR
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar en Tomcat
FROM tomcat:8.5-jdk8

# Eliminar la app por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el WAR generado desde la etapa anterior
COPY --from=build /app/target/CrudClienteWs-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exponer puerto 8080
EXPOSE 8080

# Comando de inicio
CMD ["catalina.sh", "run"]


