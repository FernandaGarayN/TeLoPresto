FROM bellsoft/liberica-runtime-container:jdk-17-musl AS builder

WORKDIR /home/myapp

# Cache maven dependencies
COPY pom.xml mvnw /home/myapp/original-source/
COPY .mvn /home/myapp/original-source/.mvn

WORKDIR /home/myapp/original-source

RUN chmod u+x mvnw && ./mvnw dependency:go-offline -B

ADD . /home/myapp/original-source

RUN ./mvnw clean package -DskipTests


FROM bellsoft/liberica-runtime-container:jre-17-musl AS deploy

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

WORKDIR /home/myapp

COPY --from=builder /home/myapp/original-source/target/*.jar app.jar

EXPOSE 8091

CMD ["java", "-jar", "app.jar"]
