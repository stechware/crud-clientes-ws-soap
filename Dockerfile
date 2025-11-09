# Imagen base: Tomcat con Java 8
FROM tomcat:8.5-jdk8

# Elimina la aplicación por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu WAR al directorio de despliegue de Tomcat
COPY target/CrudClienteWs-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto que usará Render
EXPOSE 8080

# Render asigna un puerto dinámico, usamos variable de entorno
CMD ["catalina.sh", "run"]
