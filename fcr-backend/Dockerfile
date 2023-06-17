FROM registry.access.redhat.com/ubi8/openjdk-17:1.15

WORKDIR /app

COPY . .

RUN ./mvnw clean install -DskipTests

CMD ["java", "-jar", "./target/fcr-backend-1.0-SNAPSHOT.jar"]
