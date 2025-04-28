# Etap 1: build aplikacji
FROM openjdk:21-jdk-slim as builder

WORKDIR /app

COPY gradlew gradlew.bat ./
COPY build.gradle settings.gradle ./
COPY ./gradle ./gradle
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon

# Etap 2: budowanie końcowego obrazu
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]