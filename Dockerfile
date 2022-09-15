FROM openjdk:17-alpine
EXPOSE 8080
ADD target/taller-simulation-practice-four.jar taller-simulation-practice-four.jar
ENTRYPOINT ["java", "-jar", "/taller-simulation-practice-four.jar"]
