package com.talevski.viktor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudNetflixEurekaClientCalledTwoApplication {
    public static void main(String[] args) {
        run(SpringCloudNetflixEurekaClientCalledTwoApplication.class, args);
    }
}
