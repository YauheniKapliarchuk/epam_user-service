FROM openjdk:latest
ARG JAR_FILE=build/libs/user-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
EXPOSE 8080
