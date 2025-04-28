FROM openjdk:21-jdk-slim

WORKDIR /app

COPY gradlew gradlew.bat ./
COPY build.gradle settings.gradle ./
COPY ./gradle ./gradle

RUN ./gradlew dependencies --no-daemon

COPY . ./

RUN ./gradlew build --no-daemon

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
