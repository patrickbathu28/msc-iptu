FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/msc-iptu-0.0.1-SNAPSHOT.jar app.jar
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 8084