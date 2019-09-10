FROM openjdk:8
ADD build/libs/petbackend.jar petbackend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "petbackend.jar"]