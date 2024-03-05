package com.ecommerce.prices.infrastructure.controllers;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.dtos.PriceOutputDTO;
import com.ecommerce.prices.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para manejar las operaciones relacionadas con los precios.
 */
@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    /**
     * Constructor que inyecta el servicio de precios.
     *
     * @param priceService Servicio de precios a inyectar.
     */
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Endpoint para obtener precios por ID de marca, ID de producto y rango de fechas.
     *
     * @param brandId      ID de la marca.
     * @param productId    ID del producto.
     * @param startDateStr Fecha de inicio del rango en formato de cadena "yyyy-MM-dd".
     * @param endDateStr   Fecha de fin del rango en formato de cadena "yyyy-MM-dd".
     * @return ResponseEntity con la lista de precios encontrados y código de estado HTTP correspondiente.
     */
    @GetMapping("/pricesByBrandIdAndProductIdAndDate")
    public ResponseEntity<List<PriceOutputDTO>> getPricesByBrandIdAndProductIdAndDate(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId,
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr) {
         try {
            Date startDate = DateUtils.parseDate(startDateStr);
            Date endDate = DateUtils.parseDate(endDateStr);
             // Conversión de las cadenas de fecha a objetos Date
            if (!DateUtils.isValidDateRange(startDate, endDate)) {
                return ResponseEntity.badRequest().build();
            }

            List<PriceOutputDTO> pricesOutput = priceService.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
            return ResponseEntity.ok(pricesOutput);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint para obtener precios por ID de marca y ID de producto.
     *
     * @param brandId   ID de la marca.
     * @param productId ID del producto.
     * @return ResponseEntity con la lista de precios encontrados y código de estado HTTP correspondiente.
     */
    @GetMapping("/pricesByBrandIdAndProductId")
    public ResponseEntity<List<Price>> getPricesByBrandIdAndProductId(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId) {
        // Obtener precios utilizando el servicio
        List<Price> prices = priceService.getPricesByBrandIdAndProductId(brandId, productId);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    /**
     * Endpoint para realizar una prueba del API.
     *
     * @return ResponseEntity con un mensaje de prueba y código de estado HTTP correspondiente.
     */
    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return new ResponseEntity<>("API Test OK", HttpStatus.OK);
    }
}
