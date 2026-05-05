# Build
FROM gradle:8.14-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# Run
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]