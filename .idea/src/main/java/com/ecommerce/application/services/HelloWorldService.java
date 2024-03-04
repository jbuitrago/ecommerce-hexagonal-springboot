package com.ecommerce.application.services;

import com.ecommerce.adapters.outbound.persistence.GreetingRepository;
import com.ecommerce.domain.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public HelloWorldService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting sayHello() {
        return greetingRepository.findGreeting();
    }
}