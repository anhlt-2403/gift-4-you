FROM maven:3.8.6-openjdk-18 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/gift-4-you-0.0.1-SNAPSHOT.jar /app/gift-4-you.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/gift-4-you.jar"]
