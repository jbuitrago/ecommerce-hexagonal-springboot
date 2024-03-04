package com.ecommerce.adapters.inbound.controllers;
import com.ecommerce.application.services.HelloWorldService;
import com.ecommerce.domain.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/hello")
    public Greeting sayHello() {
        return helloWorldService.sayHello();
    }
}