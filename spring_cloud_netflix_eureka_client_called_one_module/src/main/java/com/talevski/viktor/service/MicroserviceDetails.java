package com.talevski.viktor.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "details")
@RefreshScope
@Data
public class MicroserviceDetails {
    private String moduleName;
    private String endpointName;
    private String message;
}
