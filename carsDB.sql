CREATE DATABASE IF NOT EXISTS cars;

USE cars;

CREATE TABLE customers (
	id INTEGER AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    street VARCHAR(25) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state CHAR(2) NOT NULL,
    zip CHAR(5) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE cars (
id INTEGER AUTO_INCREMENT NOT NULL,
vin VARCHAR(17) NOT NULL,
year YEAR(4) NOT NULL,
make VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
price DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE orders (
id INTEGER AUTO_INCREMENT NOT NULL,
customer_id INTEGER NOT NULL,
car_id INTEGER NOT NULL,
date_ordered DATETIME NOT NULL,
total DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (car_id) REFERENCES cars(id)
);

CREATE VIEW order_data AS 
SELECT c.first_name, c.last_name, w.make, w.model, w.year, w.vin, o.date_ordered FROM customers c
INNER JOIN orders o ON c.id = o.customer_id
INNER JOIN cars w ON w.id = o.car_id;

