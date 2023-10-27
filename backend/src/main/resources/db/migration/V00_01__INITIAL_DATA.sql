INSERT INTO subsidiary (name, address, phone_number)
VALUES  ('San Miguel', 'Gran Avenida José Miguel Carrera 5345', 223456789),
        ('Recoleta', 'Avenida Perú 2345', 223456788),
        ('San Bernardo', 'Gran Avenida José Miguel Carrera 14180', 223456790);


INSERT INTO cars (plate_code, brand, model, subsidiary_id, color, factory_year, capacity, daily_cost, type, image)
VALUES ('ABCD01', 'Chevrolet', 'Sail', 1, 'Black', '2018', '5', '70000', 'Sedan', '/autos/chevroletnegro.jpg'),
       ('XYZW23', 'Chevrolet', 'Sail', 1, 'White', '2020', '5', '70000','Sedan', '/autos/chevroletblanco.jpg'),
       ('EFGH45', 'Hyundai', 'Elantra', 2, 'Blue', '2012', '5', '50000', 'Sedan', '/autos/HyundaiAzul.jpg'),
       ('IJKL67', 'Chery', 'Tiggo3', 1, 'Grey', '2022', '5', '90000', 'SUV', '/autos/Cherygris.jpg'),
       ('MNOP89', 'Mazda', 'CX-5', 1, 'Red', '2021', '2', '600000', 'SUV', '/autos/mazdarojo.jpg'),
       ('QRST10', 'Nissan', 'Pathfinder',1, 'Grey', '2018', '7', '60000', 'SUV', '/autos/Nissangris.jpg'),
       ('UVWX12', 'Chevrolet', 'V34', 3, 'Blue', '2023', '4', '30000', 'SUV', '/autos/Chevroletazul.jpg');

INSERT INTO client (username, rut, first_name, last_name, email, phone_number, address, gift_points)
VALUES
    ('rulloa', '151913318', 'Rodrigo', 'Ulloa', 'rulload@telopresto.cl', 226251693, 'Calle Principal 123', 100),
    ('mgonzalez', '9876543210', 'María', 'González', 'maria@example.com', 226216418, 'Avenida Central 456', 50),
    ('psanchez','5555555555', 'Pedro', 'Sánchez', 'pedro@example.com', 225342263, 'Calle Secundaria 789', 75);

-- Reservas para Juan Pérez
INSERT INTO reservation (client_id, car_id, start_at, end_at)
VALUES
    (1, 1, '2023-01-15', '2023-01-31'), -- Asigna el car_id adecuado
    (1, 2, '2023-02-15', '2023-02-28'); -- Asigna el car_id adecuado

-- Reservas para María González
INSERT INTO reservation (client_id, car_id, start_at, end_at)
VALUES
    (2, 3,'2023-03-15', '2023-03-20'), -- Asigna el car_id adecuado
    (2, 4,'2023-02-10', '2023-02-15'); -- Asigna el car_id adecuado

-- Reservas para Pedro Sánchez
INSERT INTO reservation (client_id, car_id, start_at, end_at)
VALUES
    (3, 5,'2023-01-02', '2023-01-15'), -- Asigna el car_id adecuado
    (3, 6,'2023-04-15', '2023-04-25'); -- Asigna el car_id adecuado;

-- Empleados para Sucursal 1
INSERT INTO employee (subsidiary_id, first_name, last_name, position, hire_date)
VALUES
    (1, 'Carlos', 'Martínez', 'Gerente', '2022-01-15'),
    (1, 'Ana', 'López', 'Asistente', '2022-03-10');

-- Empleados para Sucursal 2
INSERT INTO employee (subsidiary_id, first_name, last_name, position, hire_date)
VALUES
    (2, 'Luis', 'García', 'Gerente', '2022-02-20'),
    (2, 'Elena', 'Rodríguez', 'Asistente', '2022-04-05');

-- Empleados para Sucursal 3
INSERT INTO employee (subsidiary_id, first_name, last_name, position, hire_date)
VALUES
    (3, 'Miguel', 'Hernández', 'Gerente', '2022-03-25'),
    (3, 'Isabel', 'Pérez', 'Asistente', '2022-05-15');

-- Comentarios para Reserva 1 (asumiendo que reservation_id = 1)
INSERT INTO comments (reservation_id, description, rate)
VALUES
    (1, 'Muy buen servicio, coche limpio y en buen estado.', 5),
    (1, 'Fácil proceso de recogida y entrega.', 4);

-- Comentarios para Reserva 2 (asumiendo que reservation_id = 2)
INSERT INTO comments (reservation_id, description, rate)
VALUES
    (2, 'El coche presentaba algunos problemas mecánicos.', 3),
    (2, 'El personal fue amable, pero hubo retrasos en la entrega.', 3);

-- Repite el proceso para las otras reservas.
