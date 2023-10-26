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

INSERT INTO client (rut, first_name, last_name, email, phone_number, address, gift_points)
VALUES
    ('1234567890', 'Juan', 'Pérez', 'juan@example.com', 5551234567, 'Calle Principal 123', 100),
    ('9876543210', 'María', 'González', 'maria@example.com', 5559876543, 'Avenida Central 456', 50),
    ('5555555555', 'Pedro', 'Sánchez', 'pedro@example.com', 5555555555, 'Calle Secundaria 789', 75);

-- Reservas para Juan Pérez
INSERT INTO reservation (client_id, car_id)
VALUES
    (1, 1), -- Asigna el car_id adecuado
    (1, 2); -- Asigna el car_id adecuado

-- Reservas para María González
INSERT INTO reservation (client_id, car_id)
VALUES
    (2, 3), -- Asigna el car_id adecuado
    (2, 4); -- Asigna el car_id adecuado

-- Reservas para Pedro Sánchez
INSERT INTO reservation (client_id, car_id)
VALUES
    (3, 5), -- Asigna el car_id adecuado
    (3, 6); -- Asigna el car_id adecuado;

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
