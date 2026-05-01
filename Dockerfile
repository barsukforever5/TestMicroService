#FROM artifactorycn.netcracker.com:17152/netcracker/qubership-java-base:25-alpine-latest
#FROM tomcat:9.0-jdk17
FROM tomcat:10.1-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*

#WORKDIR /app
#COPY target/TestMicroService-1.0-SNAPSHOT.war app.war
COPY target/TestMicroService-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["catalina.sh", "run"]




