INSERT INTO subsidiary (name, address, phone_number)
VALUES  ('San Miguel', 'Gran Avenida José Miguel Carrera 5345', 223456789),
        ('Recoleta', 'Avenida Perú 2345', 223456788),
        ('San Bernardo', 'Gran Avenida José Miguel Carrera 14180', 223456790);


INSERT INTO cars (plate_code, brand, model, subsidiary_id, color, factory_year, capacity, daily_cost, type )
VALUES ('BBCC00', 'Chevrolet', 'Sail', 1, 'Black', '2018', '5', '70000', 'Sedan'),
       ('ZZYY99', 'Chevrolet', 'Sail', 1, 'White', '2020', '5', '70000','Sedan'),
       ('YYZZ00', 'Hyundai', 'Elantra', 2, 'Blue', '2012', '5', '50000', 'Sedan'),
       ('RTXT65', 'Chery', 'Tiggo3', 1, 'Grey', '2022', '5', '90000', 'SUV'),
       ('RTXT64', 'Lego', 'Praia', 1, 'Red', '2012', '2', '100000', 'SUV'),
       ('RTXT63', 'Nissan', 'Pathfinder',1, 'Grey', '2018', '7', '60000', 'SUV'),
       ('RTXT62', 'Chevrolet', 'V34', 3, 'Blue', '2023', '4', '30000', 'SUV');

