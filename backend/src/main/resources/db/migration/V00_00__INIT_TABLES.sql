CREATE TABLE subsidiary
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name            VARCHAR(50)                          NOT NULL,
    address         VARCHAR(200)                         NOT NULL,
    phone_number    INT                                  NOT NULL,
    CONSTRAINT pk_subsidiary PRIMARY KEY (id)
);

CREATE TABLE cars
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    plate_code      VARCHAR(6)                           NOT NULL,
    brand           VARCHAR(30)                          NOT NULL,
    model           VARCHAR(30)                          NOT NULL,
    subsidiary_id   INT                                  NOT NULL,
    color           VARCHAR(10)                          NOT NULL,
    factory_year    INT                                  NOT NULL,
    capacity        INT                                  NOT NULL,
    daily_cost      INT                                  NOT NULL,
    type            VARCHAR(30)                          NOT NULL,
    CONSTRAINT pk_cars PRIMARY KEY (id),
    CONSTRAINT fk_cars_subsidiary FOREIGN KEY (subsidiary_id) REFERENCES subsidiary (id)
);

CREATE TABLE client
(
    id           INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username     VARCHAR(30)                          NOT NULL,
    rut          VARCHAR(10)                          NOT NULL,
    first_name   VARCHAR(50)                          NOT NULL,
    last_name    VARCHAR(50)                          NOT NULL,
    email        VARCHAR(50)                          NOT NULL,
    phone_number INT                                  NOT NULL,
    address      VARCHAR(200)                         NOT NULL,
    gift_points  INT                                  NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE reservation
(
    id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    client_id INT                           NOT NULL,
    car_id    INT                           NOT NULL,
    CONSTRAINT pk_reservation PRIMARY KEY (id),
    CONSTRAINT fk_reservation_client FOREIGN KEY (client_id) REFERENCES client (id),
    CONSTRAINT fk_reservation_car FOREIGN KEY (car_id) REFERENCES cars (id)
);

CREATE TABLE employee
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    subsidiary_id   INT                                  NOT NULL,
    first_name      VARCHAR(50)                          NOT NULL,
    last_name       VARCHAR(50)                          NOT NULL,
    position        VARCHAR(50)                          NOT NULL,
    hire_date       DATE                                 NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id),
    CONSTRAINT fk_employee_subsidiary FOREIGN KEY (subsidiary_id) REFERENCES subsidiary (id)
);

CREATE TABLE comments
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    reservation_id  INT                                  NOT NULL,
    description     VARCHAR(1000)                        NOT NULL,
    rate            INT                                  NOT NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id),
    CONSTRAINT fk_comments_reservation FOREIGN KEY (reservation_id) REFERENCES reservation (id)
);

CREATE TABLE payments
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    reservation_id  INT                                  NOT NULL,
    type            VARCHAR(25)                          NOT NULL,
    amount          INT                                  NOT NULL,
    payment_date    DATE                                 NOT NULL,
    CONSTRAINT pk_payments PRIMARY KEY (id),
    CONSTRAINT fk_payments_reservation FOREIGN KEY (reservation_id) REFERENCES reservation (id)
);