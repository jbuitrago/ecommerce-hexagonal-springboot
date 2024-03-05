package com.ecommerce.prices.application.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.infrastructure.dtos.PriceOutputDTO;

public class PriceServiceTest {

    @Test
    public void testGetPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc() {
        // Mock del caso de uso
        GetPriceUseCase getPriceUseCase = mock(GetPriceUseCase.class);

        // Instancia de PriceService con el mock del caso de uso
        PriceService priceService = new PriceService(getPriceUseCase);

        // Datos de prueba
        Long brandId = 1L;
        Long productId = 35455L;
        String priceList = "1";
        Date startDate = new Date(2020, 06, 14, 00, 00, 00);
        Date endDate = new Date(2020, 12, 31, 23, 59, 59);
        BigDecimal price = BigDecimal.valueOf(35.5);

        // Resultado esperado
        List<PriceOutputDTO> expectedPrices = Arrays.asList(
                new PriceOutputDTO(productId,brandId,priceList,startDate,endDate,price)
        );
        // Configurar comportamiento del mock
        when(getPriceUseCase.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate))
                .thenReturn(expectedPrices);

        // Llamar al método bajo prueba
        List<PriceOutputDTO> actualPrices = priceService.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);

        // Verificar el resultado
        assertEquals(expectedPrices, actualPrices);
    }

    @Test
    public void testGetPricesByBrandIdAndProductId() {
        // Mock del caso de uso
        GetPriceUseCase getPriceUseCase = mock(GetPriceUseCase.class);

        // Instancia de PriceService con el mock del caso de uso
        PriceService priceService = new PriceService(getPriceUseCase);

        // Datos de prueba
        Long brandId = 1L;
        Long productId = 35455L;
        Date startDate = new Date(2020, 06, 14, 00, 00, 00);
        Date endDate = new Date(2020, 12, 31, 23, 59, 59);
        // Resultado esperado
        List<Price> expectedPrices = Arrays.asList(new Price(1L, 1L, startDate, endDate, "1", 35455L, 0, new BigDecimal("35.50"), "EUR"));

        // Configurar comportamiento del mock
        when(getPriceUseCase.getPricesByBrandIdAndProductId(brandId, productId)).thenReturn(expectedPrices);

        // Llamar al método bajo prueba
        List<Price> actualPrices = priceService.getPricesByBrandIdAndProductId(brandId, productId);

        // Verificar el resultado
        assertEquals(expectedPrices, actualPrices);
    }
}
