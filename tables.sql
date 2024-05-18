CREATE TABLE IF NOT EXISTS CLIENTES (
  documento INT NOT NULL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  correo VARCHAR(150) NOT NULL
);
CREATE TABLE IF NOT EXISTS PERSONAL (
    idPersonal INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    contacto TEXT,
    disponible INTEGER
);


CREATE TABLE IF NOT EXISTS RESERVA (
    idReserva INTEGER PRIMARY KEY AUTOINCREMENT,
    lugar TEXT NOT NULL,
    evento TEXT NOT NULL,
    musica TEXT,
    comida TEXT,
    seguridad TEXT,
    direccion TEXT NOT NULL,
    fecha TEXT NOT NULL
    );


INSERT INTO PERSONAL (nombre, apellido, contacto, disponible)
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 1);

INSERT INTO CLIENTES (documento, nombre, apellido, telefono, direccion, correo, metodopago) VALUES (123456789, 'John', 'Doe', '1234567890', '123 Main St', 'john.doe@example.com', 'Credit Card'), (987654321, 'Jane', 'Smith', '9876543210', '456 Elm St', 'jane.smith@example.com', 'PayPal'), (456789123, 'Alice', 'Johnson', '4567891230', '789 Oak St', 'alice.johnson@example.com', 'Cash');
