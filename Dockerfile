FROM openjdk:8
ARG JAR_FILE=/bootJar/microservice-TripPricer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]