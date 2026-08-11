#FROM maven:3.9.9-eclipse-temurin-21 AS BUILDER
#
##Working directory inside a container
#WORKDIR /app
#
#COPY pom.xml .
#
##cache the dependency unless the change has detected
#RUN mvn dependency:go-offline -B
#
#COPY src ./src
#
#RUN mvn clean package
#
#FROM eclipse-temurin:21-jdk AS RUNNER
#
#COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar
#
#EXPOSE 4000
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 4002

ENTRYPOINT ["java", "-jar", "app.jar"]