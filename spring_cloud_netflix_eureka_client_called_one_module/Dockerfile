FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-spring-cloud-netflix-eureka-client-called-one-module.jar ./api-jva-spring-boot-spring-cloud-netflix-eureka-client-called-one-module.jar
ADD ./entryPoint.bash ./entryPoint.bash

EXPOSE ${PORT_NUMBER}

RUN ["chmod", "+x", "./entryPoint.bash"]
ENTRYPOINT ["./entryPoint.bash"]
