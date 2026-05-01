FROM artifactorycn.netcracker.com:17152/netcracker/qubership-java-base:25-alpine-latest

WORKDIR /app
COPY target/TestMicroService-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]