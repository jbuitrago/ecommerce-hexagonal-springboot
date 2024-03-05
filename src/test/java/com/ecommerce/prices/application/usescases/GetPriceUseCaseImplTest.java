package com.ecommerce.prices.application.usescases;
import com.ecommerce.prices.application.usecases.GetPriceUseCaseImpl;
import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.dtos.PriceOutputDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GetPriceUseCaseImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    private GetPriceUseCaseImpl getPriceUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getPriceUseCase = new GetPriceUseCaseImpl(priceRepositoryPort);
    }

    @Test
    void getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc() {
        // Mocking data
        Long brandId = 1L;
        Long productId = 1L;
        Date startDate = new Date(2020, 06, 14, 00, 00, 00);
        Date endDate = new Date(2020, 12, 31, 23, 59, 59);
        List<Price> prices = Arrays.asList(
                new Price(2L,1L,startDate,endDate,"1",35455L,1, BigDecimal.valueOf(10.0),"EUR"),
                new Price(2L,1L,startDate,endDate,"1",35455L,1, BigDecimal.valueOf(30.5),"EUR")
        );

        // Mocking repository method
        when(priceRepositoryPort.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate))
                .thenReturn(prices);

        // Calling the method under test
        List<PriceOutputDTO> priceOutputDTOList = getPriceUseCase.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);

        // Verifying the result
        assertEquals(2, priceOutputDTOList.size());
        assertEquals(BigDecimal.valueOf(10.0), priceOutputDTOList.get(0).getPrice());
        assertEquals(BigDecimal.valueOf(30.5), priceOutputDTOList.get(1).getPrice());
    }
}
