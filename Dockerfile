FROM openjdk:17

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-javaagent:/opt/javaagent.jar", "-jar", "/app.jar"]
