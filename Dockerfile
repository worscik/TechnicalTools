FROM openjdk:17-jdk-slim-buster
EXPOSE 80
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]