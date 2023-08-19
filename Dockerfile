FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/security-0.0.1-SNAPSHOT.jar app.jar
ENV DB_URL_LOGIN ${DB_URL_LOGIN}
ENV DB_USERNAME ${DB_USERNAME}
ENV DB_PASSWORD ${DB_PASSWORD}
ENV PROFILE ${PROFILE}

EXPOSE 8090
ENTRYPOINT ["java", "-Dspring.profiles.active=$PROFILE", "-Duser.timezone=GMT-5", "-jar", "app.jar"]
