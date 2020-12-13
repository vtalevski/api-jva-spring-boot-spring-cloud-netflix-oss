package com.talevski.viktor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CallerResponse {
    private String apiName;
    private String portNumber;
    private String moduleName;
    private String endpointName;
    private String message;
    private List<CalledResponse> calledMessages;
}
