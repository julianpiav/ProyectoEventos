#!/bin/bash

# Construir la imagen de Docker
docker build -t backend -f Dockerfile.spring .

# Detener y eliminar el contenedor antiguo
docker stop backend || true
docker rm backend || true

# Iniciar un nuevo contenedor con la imagen recién construida
docker run -d --name backend -p 8080:8080 -v proyecto-db:/data backend

# Crear un enlace simbólico en el directorio raíz al archivo de la base de datos
docker exec backend ln -s /data/proyecto.db /proyecto.db
