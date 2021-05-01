FROM adoptopenjdk/openjdk11
WORKDIR /usr/src/clinic
COPY /target/*.jar /usr/src/clinic
EXPOSE 8080
CMD ["java","-jar", "-DskipTests","/usr/src/clinic/clinic-history-0.0.1-SNAPSHOT.jar"]