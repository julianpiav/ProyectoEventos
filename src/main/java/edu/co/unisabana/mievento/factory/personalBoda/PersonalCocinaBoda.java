package edu.co.unisabana.mievento.factory.personalBoda;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.PersonalCocina;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PersonalCocinaBoda implements PersonalCocina {

    @Override
    public List<Personal> obtenerPersonalBasico(List<Personal> personal) {
        Optional<Personal> chefPastel= personal.stream().filter(person -> person instanceof Chef
                && person.isDisponible() && ((Chef) person).isPastelBoda()).findFirst();
        List<Personal> personalRequerido= personal.stream()
                .filter(p -> p instanceof Chef &&
                        ((Chef) p).getTipoComida() == TipoComida.BASICO &&
                        p.isDisponible())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList::new));
        chefPastel.ifPresent(value -> personalRequerido.add(0, value));
        return personalRequerido;
    }

    @Override
    public List<Personal> obtenerPersonalFuerte(List<Personal> personal) {
        Optional<Personal> chefPastel= personal.stream().filter(person -> person instanceof Chef
                && person.isDisponible() && ((Chef) person).isPastelBoda()).findFirst();
        List<Personal> personalRequerido= personal.stream()
                .filter(p -> p instanceof Chef &&
                        ((Chef) p).getTipoComida() == TipoComida.BASICO &&
                        p.isDisponible())
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));
        chefPastel.ifPresent(value -> personalRequerido.add(0, value));
        return personalRequerido;
    }
}
