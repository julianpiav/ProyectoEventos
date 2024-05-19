package edu.co.unisabana.mievento.entities.personal;

import java.util.ArrayList;

public interface PersonalLogistica {
    ArrayList<Personal> obtenerPersonalPequeno(ArrayList<Personal> personal);
    ArrayList<Personal> obtenerPersonalMediano(ArrayList<Personal> personal) ;
    ArrayList<Personal> obtenerPersonalGrande(ArrayList<Personal> personal);
}
