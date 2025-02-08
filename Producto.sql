CREATE TABLE PRODUCTOS (
    ID NUMBER NOT NULL,
    DESCRIPCION VARCHAR2(255 CHAR),
    NOMBRE VARCHAR2(255 CHAR),
    PRECIO FLOAT,
    STOCK NUMBER(10,0),
    CONSTRAINT PRODUCTOS_PK PRIMARY KEY (ID)
);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, STOCK)
VALUES ('Laptop HP 15', 
        'Laptop HP de 15 pulgadas con procesador Intel Core i5, 8GB RAM y 256GB SSD', 
        15000, 
        10);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, STOCK)
VALUES ('Smartphone Samsung Galaxy S21', 
        'Smartphone Samsung con pantalla AMOLED, 128GB y cámara de alta resolución', 
        20000, 
        20);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, STOCK)
VALUES ('Impresora Epson EcoTank', 
        'Impresora multifunción Epson EcoTank con sistema de tinta recargable', 
        7000, 
        5);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, STOCK)
VALUES ('Teclado Logitech K120', 
        'Teclado USB Logitech de diseño ergonómico y alta durabilidad', 
        800, 
        50);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, STOCK)
VALUES ('Monitor Dell 24"', 
        'Monitor Dell de 24 pulgadas con resolución Full HD y tecnología IPS', 
        6000, 
        15);

COMMIT;
