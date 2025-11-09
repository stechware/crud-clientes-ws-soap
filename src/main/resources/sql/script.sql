-- Crear la base de datos
DROP DATABASE IF EXISTS bdclientes;
CREATE DATABASE bdclientes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bdclientes;

-- Crear tabla clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(80) NOT NULL,
    telefono VARCHAR(15) NOT NULL
);

-- Insertar 10 clientes de ejemplo
INSERT INTO clientes (nombre, apellido, correo, telefono) VALUES
('Ana', 'Gómez', 'ana.gomez@mail.com', '999555444'),
('Luis', 'Torres', 'luis.torres@mail.com', '988777666'),
('María', 'Flores', 'maria.flores@mail.com', '955112233'),
('Pedro', 'Ramírez', 'pedro.ramirez@mail.com', '900111222'),
('Lucía', 'Vega', 'lucia.vega@mail.com', '911223344'),
('José', 'Rojas', 'jose.rojas@mail.com', '922334455'),
('Carmen', 'Díaz', 'carmen.diaz@mail.com', '933445566'),
('Miguel', 'Pérez', 'miguel.perez@mail.com', '944556677'),
('Paola', 'Reyes', 'paola.reyes@mail.com', '955667788'),
('Andrés', 'Silva', 'andres.silva@mail.com', '966778899');

select * from clientes