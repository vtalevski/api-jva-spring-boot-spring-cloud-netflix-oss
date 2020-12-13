package com.talevski.viktor.api;

import com.talevski.viktor.model.CallerResponse;
import com.talevski.viktor.service.CallerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CallerController {
    private CallerService callerService;

    public CallerController(CallerService callerService) {
        this.callerService = callerService;
    }

    @GetMapping(value = "/caller")
    public CallerResponse getCaller() {
        log.info("This is the getCaller method of the CallerController class.");
        return callerService.getCaller();
    }
}
