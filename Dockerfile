# openjdk11 image pull
FROM adoptopenjdk/openjdk11
# 컨테이너 내에서 사용할 수 있는 변수 지정
ARG JAR_FILE_PATH=/build/libs/*.jar
# app.jar에 복사
COPY ${JAR_FILE_PATH} app.jar
# 컨테이너 실행시 jar 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]