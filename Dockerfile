FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/rest-spring-boot-kotlin-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-Dspring.profiles.active=local", "-jar", "/app/app.jar"]