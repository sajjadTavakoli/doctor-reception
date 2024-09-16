FROM openjdk:21
LABEL maintainer="doctor-reception"
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} doctor-reception.jar
ENTRYPOINT ["java","-jar","doctor-reception.jar"]
