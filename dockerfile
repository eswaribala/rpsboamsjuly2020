FROM java:8
EXPOSE 7080
ADD /target/customerapidocker-0.0.1-SNAPSHOT.jar customerapidocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","customerapidocker-0.0.1-SNAPSHOT.jar"]
