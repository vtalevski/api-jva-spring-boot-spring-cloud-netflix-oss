package com.talevski.viktor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class SpringCloudNetflixEurekaClientConfigurationServerApplication {
    public static void main(String[] args) {
        run(SpringCloudNetflixEurekaClientConfigurationServerApplication.class, args);
    }
}

