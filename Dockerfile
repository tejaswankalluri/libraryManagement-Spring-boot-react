# Use a base image with Java 11
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY target/LibraryManagement-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Set the command to run your application
CMD ["java", "-jar", "app.jar"]