FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY final-project/build/libs/final-project-0.0.1-SNAPSHOT.jar docker-app.jar
EXPOSE 8085
ENV TZ Asia/Seoul
CMD ["java","-jar","docker-app.jar"]
