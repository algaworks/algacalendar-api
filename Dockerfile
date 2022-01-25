FROM openjdk:11-jre-slim

WORKDIR /

COPY target/algacalendar-0.0.1.jar /app.jar

CMD exec java $JAVA_OPTS -jar /app.jar

EXPOSE 8080
