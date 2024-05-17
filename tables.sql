CREATE TABLE IF NOT EXISTS CLIENTES (
  documento INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  direccion VARCHAR(150) NOT NULL,
  correo VARCHAR(150) NOT NULL,
  metodopago VARCHAR(50) NOT NULL
);
INSERT INTO CLIENTES (documento, nombre, apellido, telefono, direccion, correo, metodopago) VALUES (123456789, 'John', 'Doe', '1234567890', '123 Main St', 'john.doe@example.com', 'Credit Card'), (987654321, 'Jane', 'Smith', '9876543210', '456 Elm St', 'jane.smith@example.com', 'PayPal'), (456789123, 'Alice', 'Johnson', '4567891230', '789 Oak St', 'alice.johnson@example.com', 'Cash');