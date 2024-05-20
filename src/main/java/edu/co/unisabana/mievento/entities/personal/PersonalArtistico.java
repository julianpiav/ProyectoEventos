package edu.co.unisabana.mievento.entities.personal;


import java.util.List;

public interface PersonalArtistico {
    List<Personal> obtenerPersonalClasica(List<Personal> personal);
    List<Personal> obtenerPersonalUrbana(List<Personal> personal);
    List<Personal> obtenerPersonalOchentas(List<Personal> personal);
}
