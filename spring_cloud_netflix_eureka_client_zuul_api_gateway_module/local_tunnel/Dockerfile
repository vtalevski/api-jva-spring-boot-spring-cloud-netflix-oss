FROM openjdk:14-alpine

LABEL author = "Viktor Talevski"

ADD entryPoint.bash ./springCloudNetflixEurekaClientZuupApiGatewayEntryPoint.bash

RUN apk add bash

RUN apk add npm
RUN npm install -g localtunnel

RUN ["chmod", "+x", "./springCloudNetflixEurekaClientZuupApiGatewayEntryPoint.bash"]
ENTRYPOINT ["./springCloudNetflixEurekaClientZuupApiGatewayEntryPoint.bash"]
