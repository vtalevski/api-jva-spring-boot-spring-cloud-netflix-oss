package com.talevski.viktor.service;

import com.talevski.viktor.model.CalledTwoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalledTwoServiceImpl implements CalledTwoService {

    @Value("${spring.application.name}")
    private String apiName;

    @Value("${server.port}")
    private Integer portNumber;

    private MicroserviceDetails microserviceDetails;

    public CalledTwoServiceImpl(MicroserviceDetails microserviceDetails) {
        this.microserviceDetails = microserviceDetails;
    }

    @Override
    public CalledTwoResponse getCalledTwo() {
        log.info("This is the getCalledTwo method of the CalledTwoServiceImpl class.");
        return new CalledTwoResponse(apiName, "The port number is - '" + portNumber + "'.",
                microserviceDetails.getModuleName(),
                microserviceDetails.getEndpointName(),
                microserviceDetails.getMessage());
    }
}
