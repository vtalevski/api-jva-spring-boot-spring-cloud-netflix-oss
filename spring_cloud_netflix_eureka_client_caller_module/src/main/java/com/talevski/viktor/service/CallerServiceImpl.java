package com.talevski.viktor.service;

import com.talevski.viktor.model.CalledResponse;
import com.talevski.viktor.model.CallerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
@Slf4j
public class CallerServiceImpl implements CallerService {

    @Value("${spring.application.name}")
    private String apiName;

    @Value("${server.port}")
    private Integer portNumber;

    private CalledOneServiceImpl calledOneServiceImpl;
    private CalledTwoServiceImpl calledTwoServiceImpl;
    private MicroserviceDetails microserviceDetails;

    public CallerServiceImpl(CalledOneServiceImpl calledOneServiceImpl, CalledTwoServiceImpl calledTwoServiceImpl, MicroserviceDetails microserviceDetails) {
        this.calledOneServiceImpl = calledOneServiceImpl;
        this.calledTwoServiceImpl = calledTwoServiceImpl;
        this.microserviceDetails = microserviceDetails;
    }

    @Override
    public CallerResponse getCaller() {
        log.info("This is the getCaller method of the CallerServiceImpl class.");

        CalledResponse calledOneResponse = calledOneServiceImpl.getCalledOne();
        CalledResponse calledTwoResponse = calledTwoServiceImpl.getCalledTwo();

        return new CallerResponse(apiName, "The port number is - '" + portNumber + "'.",
                microserviceDetails.getModuleName(),
                microserviceDetails.getEndpointName(),
                microserviceDetails.getMessage(),
                asList(calledOneResponse, calledTwoResponse));
    }
}
