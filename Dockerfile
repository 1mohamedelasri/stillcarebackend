FROM openjdk:15
ADD target/stillcare-1.0.jar stillcare-1.0.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","stillcare-1.0.jar"]
ADD 1melasri /root/.ssh/id_rsa