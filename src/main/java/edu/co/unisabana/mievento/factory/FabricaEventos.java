package edu.co.unisabana.mievento.factory;

import edu.co.unisabana.mievento.entities.reserva.evento.Boda;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.evento.QuinceAnos;

public class FabricaEventos {
    public  void identificarEvento(Evento evento) {
        if (evento instanceof Boda){

        }else if(evento instanceof QuinceAnos){

        }else {

        }


    }
}
