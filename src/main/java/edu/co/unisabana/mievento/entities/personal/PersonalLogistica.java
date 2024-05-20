package edu.co.unisabana.mievento.entities.personal;

import java.util.List;

public interface PersonalLogistica {
    List<Personal> obtenerPersonalPequeno(List<Personal> personal);
    List<Personal> obtenerPersonalMediano(List<Personal> personal) ;
    List<Personal> obtenerPersonalGrande(List<Personal> personal);
}
