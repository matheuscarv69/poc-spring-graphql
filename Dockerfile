## simple dockerfile sintax
#FROM openjdk:11-slim
#MAINTAINER matheuscarv69
#
#ARG JAR_FILE=target/poc-java-graphql-0.0.1-SNAPSHOT.jar
#ADD ${JAR_FILE} app.jar
#
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]


## multi stage build

## Builder image
FROM maven:3.6.3-jdk-11 as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

## Runner image
FROM openjdk:11-slim
MAINTAINER matheuscarv69
COPY --from=builder /usr/src/app/target/poc-java-graphql-0.0.1-SNAPSHOT.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]