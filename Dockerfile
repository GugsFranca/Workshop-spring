# Estágio de compilação
FROM maven:3-amazoncorretto-17 as build
RUN mkdir -p /usr/Java/curso
WORKDIR /usr/Java/curso
COPY . .
RUN mvn package

# Estágio de produção
FROM eclipse-temurin:17-jdk
RUN mkdir -p /app
WORKDIR /app
COPY --from=build /usr/Java/curso/target/curso.jar app.jar
CMD ["java", "-jar", "app.jar"]
