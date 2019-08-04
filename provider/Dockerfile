FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
EXPOSE 12345
EXPOSE 9090
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]