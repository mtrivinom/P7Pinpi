FROM maven:3.8-openjdk-11-slim AS builder

LABEL maintainer="cbanciu@uoc.edu"

WORKDIR /code:
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

