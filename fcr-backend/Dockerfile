# Use a suitable base image for Java and Maven
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Quarkus application files to the container
COPY . .

# Build the Quarkus application
RUN mvn clean install -DskipTests

# Use a lighter base image for the runtime
FROM registry.access.redhat.com/ubi8/openjdk-17:1.15

# Set the working directory inside the container
WORKDIR /deployments/
USER 185

# Copy the built JAR from the build stage
COPY --from=build /app/target/quarkus-app/lib/ /deployments/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployments/
COPY --from=build /app/target/quarkus-app/app/ /deployments/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080

# Set the command to start the Quarkus application
CMD ["java", "-Dquarkus.http.host=0.0.0.0", "-Djava.util.logging.manager=org.jboss.logmanager.LogManager", "-jar", "/deployments/quarkus-run.jar"]
