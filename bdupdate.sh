docker run -v /home/santiago-santafe/Desktop/ProyectoEventos/proyecto.db:/db/proyecto.db -v proyecto-db:/volumen --name temp-container -d ubuntu tail -f /dev/null

docker exec temp-container cp /db/proyecto.db /volumen/
