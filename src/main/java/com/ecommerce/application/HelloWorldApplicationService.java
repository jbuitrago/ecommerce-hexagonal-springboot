package com.ecommerce.application;

import org.springframework.stereotype.Service;
import com.ecommerce.domain.HelloWorldService;

@Service
public class HelloWorldApplicationService implements HelloWorldService {

    @Override
    public String getHelloMessage() {
        return "¡Hola Mundo!";
    }
}
