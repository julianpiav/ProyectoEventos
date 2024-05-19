/*CREATE TABLE IF NOT EXISTS CLIENTES (
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
    contacto TEXT NOT NULL,
    disponible INTEGER,
    cargo TEXT NOT NULL, -- Nuevo campo para determinar el tipo de personal (Logistica, Musico, Artista)
    implementos TEXT, -- Nuevo campo para Logistica
    instrumentoPrincipal TEXT, -- Nuevo campo para Musico
    generoMusical TEXT, -- Nuevo campo para Musico
    idArtista INTEGER, -- Nuevo campo para Artista
    generoArtistico TEXT, -- Nuevo campo para Artista
    estilo TEXT, -- Nuevo campo para Artista
    experienciaAños INTEGER -- Nuevo campo para Artista
);

CREATE TABLE RESERVA (
    idReserva INTEGER PRIMARY KEY,
    lugar TEXT,
    musica TEXT,
    comida TEXT,
    direccion TEXT,
    fecha TEXT,
    metodoPago TEXT,
    eventoId INTEGER,
    FOREIGN KEY(eventoId) REFERENCES EVENTO(idEvento)
);

 */

INSERT INTO RESERVA (idReserva, lugar, musica, comida, direccion, fecha, metodoPago, eventoId)
VALUES (1, 'Parque Central', 'URBANA', 'FUERTE', 'Calle 10 #20-30', '2024-06-30', 'Tarjeta de crédito', 101);

INSERT INTO RESERVA (idReserva, lugar, musica, comida, direccion, fecha, metodoPago, eventoId)
VALUES (2, 'Estadio Municipal', 'CLASICA', 'BASICO', 'Avenida 15 #30-40', '2024-07-15', 'Efectivo', 102);


    

-- Insertar un registro de tipo 'Todero'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, implementos)
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 1, 'Todero', 'Carro, Laptop');

-- Insertar un registro de tipo 'Musico'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, instrumentoPrincipal, generoMusical)
VALUES ('Maria', 'Gomez', 'maria.gomez@example.com', 1, 'Musico', 'Guitarra', 'Rock');

-- Insertar un registro de tipo 'Artista'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, idArtista, generoArtistico, estilo, experienciaAños)
VALUES ('Carlos', 'Rodriguez', 'carlos.rodriguez@example.com', 1, 'Artista', 123, 'Danza', 'Contemporánea', 5);

CREATE TABLE EVENTO (
    idEvento INTEGER PRIMARY KEY,
    nombre TEXT,
    descripcion TEXT,
    fecha TEXT,
    horaInicio TEXT,
    horaFin TEXT,
    capacidadMaxima INTEGER,
    tipoMusica TEXT,
    tipoComida TEXT,
    administradorId INTEGER,
    FOREIGN KEY(administradorId) REFERENCES ADMINISTRADOR(documento)
);

INSERT INTO EVENTO (idEvento, nombre, descripcion, fecha, horaInicio, horaFin, capacidadMaxima, tipoMusica, tipoComida, administradorId)
VALUES (101, 'Festival de Música', 'Un festival de música al aire libre.', '2024-06-30', '10:00', '22:00', 5000, 'URBANA', 'FUERTE', 123456789);

INSERT INTO EVENTO (idEvento, nombre, descripcion, fecha, horaInicio, horaFin, capacidadMaxima, tipoMusica, tipoComida, administradorId)
VALUES (102, 'Concierto Clásico', 'Un concierto de música clásica en el auditorio.', '2024-07-15', '19:00', '21:00', 1000, 'CLASICA', 'BASICO', 987654321);
