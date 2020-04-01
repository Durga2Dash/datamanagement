# For Java 8, try this
FROM openjdk:8-jdk-alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/datamanagement-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

#Creating Volume
VOLUME /tmp

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]