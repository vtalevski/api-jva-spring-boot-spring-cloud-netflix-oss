FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-spring-cloud-netflix-eureka-client-caller-module.jar ./api-jva-spring-boot-spring-cloud-netflix-eureka-client-caller-module.jar
ADD ./entryPoint.bash ./entryPoint.bash

EXPOSE 8080

RUN ["chmod", "+x", "./entryPoint.bash"]
ENTRYPOINT ["./entryPoint.bash"]
