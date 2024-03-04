package com.ecommerce.adapters.outbound.persistence;

import com.ecommerce.domain.model.Greeting;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepository {

    public Greeting findGreeting() {
        return new Greeting("¡Hola Mundo!");
    }
}
