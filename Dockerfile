FROM openjdk:8-jdk-alpine
MAINTAINER Yaroslv Brek
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ybr-crud-app.jar
ENTRYPOINT ["java","-jar","/ybr-crud-app.jar"]