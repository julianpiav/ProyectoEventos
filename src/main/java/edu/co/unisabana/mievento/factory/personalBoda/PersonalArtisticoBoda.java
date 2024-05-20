package edu.co.unisabana.mievento.factory.personalBoda;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalArtistico;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class PersonalArtisticoBoda implements PersonalArtistico {

    @Override
    public List<Personal> obtenerPersonalClasica(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.CLASICA && p.isDisponible())
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Personal> obtenerPersonalUrbana(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.URBANA && p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Personal> obtenerPersonalOchentas(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.OCHENTAS && p.isDisponible())
                .limit(4)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
