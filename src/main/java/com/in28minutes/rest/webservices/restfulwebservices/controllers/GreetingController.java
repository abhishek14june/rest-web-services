package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import com.in28minutes.rest.webservices.restfulwebservices.dto.AuthRequest;
import com.in28minutes.rest.webservices.restfulwebservices.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

    @Autowired
    JwtService jwtService;
    @Value("${my.greeting}")
    private String greetingMesage;
    @GetMapping("/greeting")
    public String greeting(){
        return greetingMesage;
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        return  jwtService.generateToken(authRequest.getUsername());
    }

}
