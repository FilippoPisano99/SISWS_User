FROM eclipse-temurin:17-jdk

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /
ENTRYPOINT ["java","-jar","/MicroWS.jar"]



