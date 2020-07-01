USE cars;

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Keyer', 'Soze', '2912 S. Maple Street', 'Columbus', 'OH', 43004);

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Joe', 'Smith', '10234 E. Thorn Drive', 'Rogers', 'AR', 72756);

UPDATE customers SET street = '2913 S. Maple Street' WHERE id = 1;

-- Foreign constraint:
DELETE FROM customers WHERE first_name = 'Keyer';
-- 

SELECT * FROM customers;
-- ___________________

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('4Y1SL65848Z411439', 2020, 'Subaru', 'Forester', '24495');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('19UYA31581L000000', 2020, 'Tesla', '3', '37990');

UPDATE cars SET price = '24000' WHERE vin = '4Y1SL65848Z411439';

-- Foreign constraint:
DELETE FROM cars WHERE vin = '4Y1SL65848Z411439';
-- 

SELECT * FROM cars;

-- ___________________
INSERT INTO orders(customer_id, car_id, date_ordered, total) 
VALUES (1, '1', '2020-02-04 15:00:00', '19000.00');

INSERT INTO orders(customer_id, car_id, date_ordered, total) 
VALUES (2, '2', '2020-03-17 13:55:00', '36999.00');

UPDATE orders SET total = '35868' WHERE car_id = '1';

DELETE FROM orders WHERE car_id = '2';

SELECT * FROM orders;
-- ___________________

SELECT * FROM order_data;
-- ___________________

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS orders;
DROP VIEW IF EXISTS order_data;
