FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar ms-api-gateway.jar

EXPOSE 7082

ENTRYPOINT ["java","-jar","ms-api-gateway.jar"]