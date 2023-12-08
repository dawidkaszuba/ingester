FROM openjdk:17-jdk
EXPOSE 8081
MAINTAINER pl.dawidkaszuba
COPY target/*.jar /ingester.jar

ENTRYPOINT ["java", "-jar", "/ingester.jar"]