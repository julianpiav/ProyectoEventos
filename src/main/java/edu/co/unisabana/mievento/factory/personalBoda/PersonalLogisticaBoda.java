package edu.co.unisabana.mievento.factory.personalBoda;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalLogistica;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.logistica.Todero;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PersonalLogisticaBoda implements PersonalLogistica {

    @Override
    public List<Personal> obtenerPersonalPequeno(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(4)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public List<Personal> obtenerPersonalMediano(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(6)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Personal> obtenerPersonalGrande(List<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(8)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
