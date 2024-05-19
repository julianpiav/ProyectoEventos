package edu.co.unisabana.mievento.factory.personalQuinceAnos;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalLogistica;
import edu.co.unisabana.mievento.entities.personal.logistica.Todero;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonalLogisticaQuinceAnos implements PersonalLogistica {

    @Override
    public ArrayList<Personal> obtenerPersonalPequeno(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(4)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public ArrayList<Personal> obtenerPersonalMediano(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(8)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Personal> obtenerPersonalGrande(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Todero &&  p.isDisponible())
                .limit(12)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
