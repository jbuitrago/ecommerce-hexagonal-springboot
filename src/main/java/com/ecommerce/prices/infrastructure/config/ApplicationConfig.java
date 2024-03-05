package com.ecommerce.prices.infrastructure.config;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.application.usecases.GetPriceUseCaseImpl;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.repositories.JpaPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración de la aplicación.
 */
@Configuration
public class ApplicationConfig {

    /**
     * Configura y devuelve el servicio de precios.
     *
     * @param priceRepositoryPort Puerto del repositorio de precios.
     * @return Servicio de precios configurado.
     */
    @Bean
    public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(new GetPriceUseCaseImpl(priceRepositoryPort));
    }

    /**
     * Configura y devuelve el puerto del repositorio de precios.
     *
     * @param jpaPriceRepositoryAdapter Adaptador del repositorio de precios JPA.
     * @return Puerto del repositorio de precios configurado.
     */
    @Bean
    public PriceRepositoryPort priceRepositoryPort(JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter) {
        return jpaPriceRepositoryAdapter;
    }
}
