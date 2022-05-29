FROM openjdk:17-jdk-alpine3.14
ADD target/RentalService-0.0.1-SNAPSHOT.jar .
EXPOSE 8001
CMD java -jar RentalService-0.0.1-SNAPSHOT.jar
