FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-spring-cloud-netflix-eureka-client-configuration-server-module.jar ./api-jva-spring-boot-spring-cloud-netflix-eureka-client-configuration-server-module.jar
ADD ./entryPoint.bash ./entryPoint.bash

EXPOSE 8888

RUN ["chmod", "+x", "./entryPoint.bash"]
ENTRYPOINT ["./entryPoint.bash"]
