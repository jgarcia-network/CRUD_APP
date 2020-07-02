SELECT o.id, c.first_name, c.last_name, w.make, w.model, w.year, o.total, o.date_ordered FROM customers c
INNER JOIN orders o ON c.id = o.customer_id
INNER JOIN cars w ON w.vin = o.car_vin;

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

