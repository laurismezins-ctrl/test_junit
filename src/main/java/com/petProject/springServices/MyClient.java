package com.petProject.springServices;

import org.springframework.stereotype.Component;

@Component
public class MyClient {

    public String getMessage(String message) {
        return "message: " + message;
    }
}