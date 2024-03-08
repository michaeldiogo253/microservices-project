FROM maven:3.8.5-jdk-11-slim as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar  ./app.jar
ARG RABBITMQ_SERVER=rabbitmqlocalhost
ARG MYSQL=mysqllocalhost
ARG EUREKA_SERVER=localhost

ENTRYPOINT java -jar app.jar