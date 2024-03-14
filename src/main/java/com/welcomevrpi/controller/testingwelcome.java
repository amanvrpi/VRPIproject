package com.welcomevrpi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testingwelcome {
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome to VRPI group ";
    }
}