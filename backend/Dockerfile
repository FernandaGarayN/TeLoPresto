FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /home/myapp
COPY pom.xml /home/myapp/original-source/
WORKDIR /home/myapp/original-source
ADD . /home/myapp/original-source
RUN mvn clean package -DskipTests

FROM bellsoft/liberica-runtime-container:jre-17-musl AS deploy
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /home/myapp
COPY --from=builder /home/myapp/original-source/target/*.jar app.jar
EXPOSE 8091
CMD ["java", "-jar", "app.jar"]
