package com.talevski.viktor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CalledTwoResponse {
    private String apiName;
    private String portNumber;
    private String moduleName;
    private String endpointName;
    private String message;
}
