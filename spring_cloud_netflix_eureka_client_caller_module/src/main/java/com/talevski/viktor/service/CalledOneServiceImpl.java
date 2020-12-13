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
public class CalledOneServiceImpl {

    @Value("${called_one_api.uri}")
    public String calledOneUri;

    private RestTemplate restTemplate;

    public CalledOneServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Circuit Breaker pattern.
    @HystrixCommand(fallbackMethod = "generateCalledOneFallbackResponse", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    // Bulkhead pattern.
    /*@HystrixCommand(fallbackMethod = "generateCalledOneFallbackResponse",
            threadPoolKey = "calledOneThreadPoolKey",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })*/
    public CalledResponse getCalledOne() {
        log.info("This is the getCalledOne method of the CalledOneServiceImpl class.");
        return restTemplate.getForObject(calledOneUri, CalledResponse.class);
    }

    public CalledResponse generateCalledOneFallbackResponse() {
        CalledResponse calledOneResponse = new CalledResponse();
        calledOneResponse.setApiName("api-jva-spring-boot-spring-cloud-netflix-eureka-client-called-one");
        calledOneResponse.setModuleName("Called One API module name not found.");
        calledOneResponse.setEndpointName("/called-one");
        calledOneResponse.setMessage("Called One API message not found.");
        return calledOneResponse;
    }
}
