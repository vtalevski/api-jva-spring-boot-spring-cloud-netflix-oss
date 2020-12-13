package com.talevski.viktor.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.talevski.viktor.model.CalledResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
@Slf4j
public class CalledTwoServiceImpl {

    @Value("${called_two_api.uri}")
    public String calledTwoUri;

    private RestTemplate restTemplate;

    public CalledTwoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Circuit Breaker pattern.
    @HystrixCommand(fallbackMethod = "generateCalledTwoFallbackResponse", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    // Bulkhead pattern.
    /*@HystrixCommand(fallbackMethod = "generateCalledTwoFallbackResponse",
            threadPoolKey = "calledTwoThreadPoolKey",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })*/
    public CalledResponse getCalledTwo() {
        log.info("This is the getCalledTwo method of the CalledTwoServiceImpl class.");
        return restTemplate.getForObject(calledTwoUri, CalledResponse.class);
    }

    public CalledResponse generateCalledTwoFallbackResponse() {
        CalledResponse calledTwoResponse = new CalledResponse();
        calledTwoResponse.setApiName("api-jva-spring-boot-spring-cloud-netflix-eureka-client-called-two");
        calledTwoResponse.setModuleName("Called Two API module name not found.");
        calledTwoResponse.setEndpointName("/called-two");
        calledTwoResponse.setMessage("Called Two API message not found.");
        return calledTwoResponse;
    }
}
