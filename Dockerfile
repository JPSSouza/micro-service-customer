FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY build/libs/customer-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "customer-0.0.1-SNAPSHOT.jar"]
