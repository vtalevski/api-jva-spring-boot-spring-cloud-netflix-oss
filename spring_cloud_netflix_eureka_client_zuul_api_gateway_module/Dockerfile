FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-spring-cloud-netflix-eureka-client-zuul-api-gateway-module.jar ./api-jva-spring-boot-spring-cloud-netflix-eureka-client-zuul-api-gateway-module.jar
ADD ./entryPoint.bash ./entryPoint.bash

EXPOSE 8090

RUN ["chmod", "+x", "./entryPoint.bash"]
ENTRYPOINT ["./entryPoint.bash"]
