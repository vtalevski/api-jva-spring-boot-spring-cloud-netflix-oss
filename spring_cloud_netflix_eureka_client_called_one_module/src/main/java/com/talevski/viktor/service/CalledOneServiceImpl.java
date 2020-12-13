package com.talevski.viktor.service;

import com.talevski.viktor.model.CalledOneResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalledOneServiceImpl implements CalledOneService {

    @Value("${spring.application.name}")
    private String apiName;

    @Value("${server.port}")
    private Integer portNumber;

    private MicroserviceDetails microserviceDetails;

    public CalledOneServiceImpl(MicroserviceDetails microserviceDetails) {
        this.microserviceDetails = microserviceDetails;
    }

    @Override
    public CalledOneResponse getCalledOne() {
        log.info("This is the getCalledOne method of the CalledOneServiceImpl class.");
        return new CalledOneResponse(apiName, "The port number is - '" + portNumber + "'.",
                microserviceDetails.getModuleName(),
                microserviceDetails.getEndpointName(),
                microserviceDetails.getMessage());
    }
}
