CREATE TABLE prices (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              brand_id BIGINT,
                              start_date TIMESTAMP,
                              end_date TIMESTAMP,
                              price_list VARCHAR(255),
                              product_id BIGINT,
                              priority INTEGER,
                              price DECIMAL(10, 2),
                              currency VARCHAR(3)
);
INSERT INTO prices(brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES
    (1, '2020-06-14 00:00:00', '2025-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
    (1, '2020-06-14 15:00:00', '2025-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
    (1, '2020-06-15 00:00:00', '2025-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
    (1, '2020-06-15 16:00:00', '2025-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR'),
    (2, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 12345, 0, 20.50, 'USD'),
    (2, '2020-06-14 15:00:00', '2023-06-14 18:30:00', 2, 54321, 1, 15.75, 'EUR'),
    (3, '2020-06-15 00:00:00', '2023-06-15 11:00:00', 3, 78945, 1, 30.00, 'USD'),
    (3, '2020-06-15 16:00:00', '2023-12-31 23:59:59', 4, 65478, 1, 42.25, 'EUR');
