FROM eclipse-temurin:17

# 사용자 추가
RUN groupadd -r myapp && useradd -r -g myapp myapp

# 어플리케이션을 실행할 디렉토리 생성 및 소유자 변경
RUN mkdir /app && chown -R myapp:myapp /app

# 애플리케이션 JAR 파일 복사
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

# 실행 사용자 변경
USER myapp

# 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]