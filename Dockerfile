FROM maven:3.5-jdk-8
VOLUME /tmp
ADD . /app
WORKDIR /app
CMD  mvn clean compile spring-boot:run
