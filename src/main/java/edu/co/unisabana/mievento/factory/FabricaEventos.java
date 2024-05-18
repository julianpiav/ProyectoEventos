package edu.co.unisabana.mievento.factory;

import edu.co.unisabana.mievento.entities.reserva.evento.Boda;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.evento.QuinceAnos;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalArtisticoBoda;

public class FabricaEventos {
    public  void identificarEvento(Evento evento) {

        if (evento instanceof Boda){

        }else if(evento instanceof QuinceAnos){

        }else {

        }
    }
    public void identificarLogistica(Evento evento){

    }
    public void identificarCocina(Evento evento){

    }
    public void identificarArtististas(Evento evento){

    }


}
