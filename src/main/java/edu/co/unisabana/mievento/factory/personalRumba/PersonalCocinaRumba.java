package edu.co.unisabana.mievento.factory.personalRumba;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalCocina;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PersonalCocinaRumba implements PersonalCocina {


    @Override
    public List<Personal> obtenerPersonalBasico(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Chef && ((Chef) p).getTipoComida()==TipoComida.BASICO && p.isDisponible())
                .limit(1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Personal> obtenerPersonalFuerte(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Chef && ((Chef) p).getTipoComida()==TipoComida.FUERTE && p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
