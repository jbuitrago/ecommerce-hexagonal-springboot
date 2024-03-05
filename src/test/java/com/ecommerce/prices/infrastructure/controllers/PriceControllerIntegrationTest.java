package com.ecommerce.prices.infrastructure.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

   @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPricesByBrandIdAndProductIdAndDate() throws Exception {
        mockMvc.perform(get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2020-06-14 00:00:00")
                        .param("endDate", "2020-10-31 23:59:59"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPeticion10AMDia14Producto35455Brand1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2022-06-14 10:00:00")
                        .param("endDate", "2022-06-14 10:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testPeticion16PMDia14Producto35455Brand1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2022-06-14 16:00:00")
                        .param("endDate", "2022-06-14 16:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testPeticion21PMDia14Producto35455Brand1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2022-06-14 21:00:00")
                        .param("endDate", "2022-06-14 21:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testPeticion10AMDia15Producto35455Brand1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2022-06-15 10:00:00")
                        .param("endDate", "2022-06-15 10:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testPeticion21AMDia15Producto35455Brand1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/pricesByBrandIdAndProductIdAndDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2022-06-15 21:00:00")
                        .param("endDate", "2022-06-15 21:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
