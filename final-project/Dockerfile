FROM eclipse-temurin:17

VOLUME /tmp

ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["nohup", "java", "-jar", "app.jar", "&"]