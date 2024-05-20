package edu.co.unisabana.mievento.entities.personal;

import java.util.List;

public interface PersonalCocina {
    List<Personal> obtenerPersonalBasico(List<Personal> personal);
    List<Personal> obtenerPersonalFuerte(List<Personal> personal);
}
