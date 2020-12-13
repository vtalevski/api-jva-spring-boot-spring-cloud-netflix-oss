package com.talevski.viktor.api;

import com.talevski.viktor.model.CalledTwoResponse;
import com.talevski.viktor.service.CalledTwoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalledTwoController {
    private CalledTwoService calledTwoService;

    public CalledTwoController(CalledTwoService calledTwoService) {
        this.calledTwoService = calledTwoService;
    }

    @GetMapping(value = "/called-two")
    public CalledTwoResponse getCalledTwo() {
        log.info("This is the getCalledTwo method of the CalledTwoController class.");
        return calledTwoService.getCalledTwo();
    }
}
