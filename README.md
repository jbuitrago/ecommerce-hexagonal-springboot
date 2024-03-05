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

## Construcción y Empaquetado

Este proyecto utiliza Maven como herramienta de gestión de dependencias y construcción. Se incluye un archivo `pom.xml` que contiene la configuración del proyecto, incluidas las dependencias necesarias.

### Empaquetado

Al construir el proyecto con Maven, se genera un archivo `.jar` que contiene la aplicación. El archivo `.jar` se crea en el directorio `target` del proyecto después de ejecutar el comando de construcción. Puedes ejecutar el siguiente comando Maven para construir el proyecto y generar el archivo `.jar`:

```bash
mvn clean package


## Uso

La aplicación proporciona endpoints RESTful para interactuar con los precios de productos:

- **GET /api/prices/pricesByBrandIdAndProductIdAndDate**: Obtiene los precios por ID de marca, ID de producto y rango de fechas.
- **GET /api/prices/pricesByBrandIdAndProductId**: Obtiene los precios por ID de marca y ID de producto.
- **GET /api/prices/test**: Realiza una prueba del API.

## Consulta Específica

Para filtrar los datos según los campos solicitados, se ha implementado un método JPA específico llamado `findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc`. Este método realiza la siguiente consulta SQL:

```sql
SELECT * FROM Prices p 
WHERE p.brandId = ? 
  AND p.productId = ? 
  AND p.startDate <= ? 
  AND p.endDate >= ? 
ORDER BY p.priority DESC
```
Se crea el archivo resources/data.sql con el script de la creacion de la tabla Prices y tambien el insert de los datos de ejemplo.
Se cargan en memoria en la base de datos H2 cuando se ejcuta la aplicacion.



## Pruebas

Se realizaron pruebas exhaustivas para garantizar el correcto funcionamiento de la aplicación en diferentes niveles. Estos son los tipos de pruebas realizadas:

- **Pruebas unitarias:** Se llevaron a cabo pruebas unitarias utilizando JUnit y Mockito para asegurar el funcionamiento correcto de cada componente de forma aislada.
- **Pruebas de integración:** Se realizaron pruebas de integración para verificar la interacción correcta entre los diferentes componentes del sistema.

### Archivos de Prueba

- `PriceServiceTest.java`: Este archivo contiene pruebas unitarias para el servicio de precios, asegurando que los métodos del servicio funcionen según lo esperado.
- `GetPriceUseCaseImplTest.java`: Aquí se encuentran pruebas unitarias para el caso de uso de obtener precios, garantizando su correcto funcionamiento.
- `PriceControllerIntegrationTest.java`: Este archivo contiene pruebas de integración para el controlador de precios, verificando la correcta interacción entre los controladores y los servicios.

Los test solicitados se encuentran en https://github.com/jbuitrago/ecommerce-hexagonal-springboot/blob/main/src/test/java/com/ecommerce/prices/infrastructure/controllers/PriceControllerIntegrationTest.java

### Postman

No se creo la documentacion con Swagger por falta de tiempo , agrego en el repositorio la coleccion ecommerce.postman_collection.json para importar en POSTMAN.



## Contribución

Las contribuciones son bienvenidas. Para cambios importantes, por favor, abre un issue primero para discutir qué te gustaría cambiar.

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)
