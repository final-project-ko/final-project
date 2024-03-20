FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY final-project/build/libs/final-project-0.0.1-SNAPSHOT.jar /opt/app/docker-app.jar
CMD ["java","-jar","docker-app.jar"]