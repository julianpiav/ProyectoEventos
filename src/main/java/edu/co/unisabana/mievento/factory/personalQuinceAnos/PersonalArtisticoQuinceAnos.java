package edu.co.unisabana.mievento.factory.personalQuinceAnos;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalArtistico;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonalArtisticoQuinceAnos implements PersonalArtistico {

    @Override
    public ArrayList<Personal> obtenerPersonalClasica(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.CLASICA && p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Personal> obtenerPersonalUrbana(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.URBANA && p.isDisponible())
                .limit(1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Personal> obtenerPersonalOchentas(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Musico && ((Musico) p).getGeneroMusical() == TipoMusica.OCHENTAS && p.isDisponible())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
