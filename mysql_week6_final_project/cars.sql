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
vin VARCHAR(17) NOT NULL,
year YEAR(4) NOT NULL,
make VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
price DECIMAL(10,2) NOT NULL,
PRIMARY KEY (vin)
);

CREATE TABLE orders (
id INTEGER AUTO_INCREMENT NOT NULL,
customer_id INTEGER NOT NULL,
car_vin VARCHAR(17) NOT NULL, 
date_ordered DATETIME NOT NULL,
total DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (car_vin) REFERENCES cars(vin)
);

ALTER TABLE cars
ADD COLUMN sold bool not null default 0 AFTER price;

UPDATE cars SET sold = false;

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Keyser', 'Soze', '2912 S. Maple Street', 'Columbus', 'OH', 43004);

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Joe', 'Smith', '10234 E. Thorn Drive', 'Rogers', 'AR', 72756);

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Anton', 'McBride', '564 N. Jones Parkway', 'Temecula', 'CA', 92589);

INSERT INTO customers(first_name, last_name, street, city, state, zip) 
VALUES ('Sookie', 'Upton', '218 S. The Happy Drive', 'Tempe', 'AZ', 85282);

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('4Y1SL65848Z411439', 2020, 'Subaru', 'Forester', '24495');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('19UYA31581L000000', 2020, 'Tesla', '3', '37990');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('KMHDU46D59U743116', 2018, 'Mercedes', 'Sprinter', '42990');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('JF2SJAFC2FH436504', 2017, 'Toyota', 'Prius', '21456');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('3C63DRML2CG207006', 1981, 'Delorean', 'DMC-12', '19950');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('2G1FB1ED2B9151655', 1974, 'Volkswagon', 'Karman-Ghia', '15660');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('KL5JD56Z86K206214', 1972, 'Cadillac', 'De Ville Sedan', '26900');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('2HNYD18665H574542', 2008, 'Cadillac', 'DTS Pro Hearse', '19500');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('KNDJT2A61C7328601', 1988, 'Yugo', 'GVL', '5500');

INSERT INTO cars(vin, year, make, model, price) 
VALUES ('1FDWE37SXWHB41295', 2019, 'Volvo', 'S60', '29738');