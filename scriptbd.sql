

-- Finalmente, puedes insertar una reserva en la tabla Reserva
INSERT INTO Reserva (lugar, musica, comida, direccion, fecha, metodoPago, evento_idEvento) VALUES ('Bogotá', 1, 0, 'Calle 123 #45-67', '2024-05-19', 'Tarjeta de crédito',1);


SELECT sql FROM sqlite_master WHERE name = 'Evento';
-- Finalmente, puedes insertar un evento en la tabla Evento
INSERT INTO Evento (nombre, descripcion, fecha, horaInicio, horaFin, capacidadMaxima, tipoMusica, tipoComida, administrador_documento) VALUES ('Mi Evento', 'Este es un evento de prueba', '2024-05-19', '10:00', '18:00', 100, 1, 0, 123456789);
-- Primero, crea la tabla Personal

-- Ahora, puedes insertar un personal en la tabla Personal
INSERT INTO Personal (nombre, apellido, contacto, disponible, cargo) VALUES ('Juan', 'Pérez', 'juan.perez@example.com', 1, 'Cocinero');

-- Finalmente, puedes insertar un administrador en la tabla Administrador
INSERT INTO Administrador (documento, nombre, apellido, telefono, correo) VALUES (123456789, 'Ana', 'Gómez', '3001234567', 'ana.gomez@example.com');
