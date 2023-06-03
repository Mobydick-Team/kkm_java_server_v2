FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/kkm
EXPOSE 3034
COPY build/libs/kkm_server_v2-0.0.1.jar kkm.jar
ENTRYPOINT ["java", "-jar", "kkm.jar"]