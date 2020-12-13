FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-spring-cloud-netflix-eureka-server-module.jar ./api-jva-spring-boot-spring-cloud-netflix-eureka-server-module.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "./api-jva-spring-boot-spring-cloud-netflix-eureka-server-module.jar"]
