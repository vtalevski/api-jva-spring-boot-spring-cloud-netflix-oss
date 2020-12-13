package com.talevski.viktor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudNetflixEurekaServerApplication {
    public static void main(String[] args) {
        run(SpringCloudNetflixEurekaServerApplication.class, args);
    }
}
