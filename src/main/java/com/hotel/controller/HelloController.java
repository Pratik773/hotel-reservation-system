package com.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {

        Map<String, String> response = new HashMap<>();

        response.put("message", "Welcome to Hotel Reservation System");

        return response;
    }
    @GetMapping("/about")
    public Map<String,String> about(){
        Map<String, String> response = new HashMap<>();
        response.put( "project:", "Hotel Reservation System");
        response.put( "Version:", "1.0");
        response.put( "Developer:", "Pratik");

        return response;

    }

}
