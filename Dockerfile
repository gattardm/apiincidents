FROM openjdk:8
EXPOSE 8585
ADD target/apiincidents.jar apiincidents.jar
ENTRYPOINT ["java","-jar","/apiincidents.jar"]