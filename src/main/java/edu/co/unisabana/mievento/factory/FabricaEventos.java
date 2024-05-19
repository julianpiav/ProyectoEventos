package edu.co.unisabana.mievento.factory;

import edu.co.unisabana.mievento.entities.reserva.evento.Boda;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.evento.QuinceAnos;
import edu.co.unisabana.mievento.entities.reserva.evento.Rumba;
import org.springframework.stereotype.Service;

@Service
public class FabricaEventos {
    public  Evento prepararEvento(Evento evento) {
        if (evento instanceof Boda boda){
            boda.prepararArtistas(boda.getTipoMusica());
            boda.prepararCocina(boda.getTipoComida());
            boda.prepararLogistica(boda.getCapacidadMaxima());
        }else if(evento instanceof QuinceAnos quinceAnos){
            quinceAnos.prepararArtistas(quinceAnos.getTipoMusica());
            quinceAnos.prepararCocina(quinceAnos.getTipoComida());
            quinceAnos.prepararLogistica(quinceAnos.getCapacidadMaxima());
        }else if (evento instanceof Rumba rumba){
            rumba.prepararArtistas(rumba.getTipoMusica());
            rumba.prepararCocina(rumba.getTipoComida());
            rumba.prepararLogistica(rumba.getCapacidadMaxima());
        }
        return evento;
    }
}
