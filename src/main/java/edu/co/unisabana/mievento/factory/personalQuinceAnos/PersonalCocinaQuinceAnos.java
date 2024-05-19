package edu.co.unisabana.mievento.factory.personalQuinceAnos;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalCocina;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonalCocinaQuinceAnos implements PersonalCocina {


    @Override
    public ArrayList<Personal> obtenerPersonalBasico(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Chef && ((Chef) p).getTipoComida()== TipoComida.BASICO && p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public ArrayList<Personal> obtenerPersonalFuerte(ArrayList<Personal> personal) {
        return personal.stream()
                .filter(p -> p instanceof Chef && ((Chef) p).getTipoComida()==TipoComida.FUERTE && p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));

    }
}
