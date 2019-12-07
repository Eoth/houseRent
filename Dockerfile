

FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE}  house-rent-docker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/house-rent-docker.jar"]