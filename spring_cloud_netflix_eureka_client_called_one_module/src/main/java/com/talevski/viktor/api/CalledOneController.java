package com.talevski.viktor.api;

import com.talevski.viktor.model.CalledOneResponse;
import com.talevski.viktor.service.CalledOneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalledOneController {
    private CalledOneService calledOneService;

    public CalledOneController(CalledOneService calledOneService) {
        this.calledOneService = calledOneService;
    }

    @GetMapping(value = "/called-one")
    public CalledOneResponse getCalledOne() {
        log.info("This is the getCalledOne method of the CalledOneController class.");
        return calledOneService.getCalledOne();
    }
}
