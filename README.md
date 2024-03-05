# Ecommerce Prices

Este proyecto es una aplicación de ejemplo que gestiona los precios de productos para un sistema de comercio electrónico.

## Descripción

La aplicación está construida en Java utilizando Spring Boot y JPA para la capa de infraestructura de persistencia. Se sigue una arquitectura de tres capas, con controladores, servicios de aplicación, y repositorios para manejar las solicitudes HTTP, la lógica de negocio y el acceso a los datos, respectivamente. La arquitectura sigue el patrón de diseño de arquitectura hexagonal y se adhiere a los principios SOLID para garantizar un diseño modular y mantenible.

## Estructura del Proyecto



## Requisitos Técnicos

- Java 17
- Spring Boot 2.7.9
- Spring Boot Starter Web
- Spring Boot DevTools
- H2 Database
- Spring Boot Starter Test
- Java Persistence API (JPA) 2.2
- Spring Boot Starter Data JPA

## Configuración

La aplicación utiliza Spring Boot, por lo que puede ser iniciada ejecutando la clase `PricesApplication.java`. Se deben configurar las propiedades del servidor y la base de datos en el archivo `application.properties`.

## Ejecución

Para ejecutar la aplicación, simplemente inicia la clase `PricesApplication.java`. La aplicación se ejecutará en el puerto predeterminado `8080`.

## Uso

La aplicación proporciona endpoints RESTful para interactuar con los precios de productos:

- **GET /api/prices/pricesByBrandIdAndProductIdAndDate**: Obtiene los precios por ID de marca, ID de producto y rango de fechas.
- **GET /api/prices/pricesByBrandIdAndProductId**: Obtiene los precios por ID de marca y ID de producto.
- **GET /api/prices/test**: Realiza una prueba del API.

## Consulta Específica

La consulta específica que estás buscando se basa en los criterios proporcionados en el método `findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc` que es un método de repositorio que utiliza convenciones de nombres de Spring Data JPA para generar la consulta SQL correspondiente.

La consulta generada se vería algo así:

```sql
SELECT * FROM PriceEntity p 
WHERE p.brandId = ? 
  AND p.productId = ? 
  AND p.startDate <= ? 
  AND p.endDate >= ? 
ORDER BY p.priority DESC
