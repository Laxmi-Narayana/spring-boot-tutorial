package com.laxminarayanagellu.spring_boot_starter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String hello() {
        return "Message: " + welcomeMessage;
    }
}
