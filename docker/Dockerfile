FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ADD target/SpringBoot2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
