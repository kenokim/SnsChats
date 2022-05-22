FROM openjdk:17
#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#COPY settings.gradle .
#RUN chmod +x ./gradlew
#RUN ./gradlew build -x test
#COPY --from=openjdk:17 build/libs/*.jar app.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]