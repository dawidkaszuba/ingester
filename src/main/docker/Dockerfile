FROM openjdk:17

EXPOSE 8080
COPY *.jar /opt/ingester.jar
WORKDIR /
ENTRYPOINT java $JAVA_OPTS -jar "/opt/ingester.jar"

