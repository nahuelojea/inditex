FROM openjdk:17
EXPOSE 8080
ADD target/inditex.jar inditex.jar
ENTRYPOINT ["java", "-jar", "/inditex.jar"]