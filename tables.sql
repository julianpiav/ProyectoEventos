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

-- Insertar un registro de tipo 'Logistica'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, implementos)
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 1, 'Logistica', 'Carro, Laptop');

-- Insertar un registro de tipo 'Musico'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, instrumentoPrincipal, generoMusical)
VALUES ('Maria', 'Gomez', 'maria.gomez@example.com', 1, 'Musico', 'Guitarra', 'Rock');

-- Insertar un registro de tipo 'Artista'
INSERT INTO PERSONAL (nombre, apellido, contacto, disponible, tipo, idArtista, generoArtistico, estilo, experienciaAños)
VALUES ('Carlos', 'Rodriguez', 'carlos.rodriguez@example.com', 1, 'Artista', 123, 'Danza', 'Contemporánea', 5);

