package com.ecommerce.prices.infrastructure.config;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.application.usecases.GetPriceUseCaseImpl;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.repositories.JpaPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(
                new GetPriceUseCaseImpl(priceRepositoryPort)
        );
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter) {
        return jpaPriceRepositoryAdapter;
    }
}
