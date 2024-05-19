package edu.co.unisabana.mievento.entities.personal;


import java.util.ArrayList;

public interface PersonalArtistico {
    ArrayList<Personal> obtenerPersonalClasica(ArrayList<Personal> personal);
    ArrayList<Personal> obtenerPersonalUrbana(ArrayList<Personal> personal);
    ArrayList<Personal> obtenerPersonalOchentas(ArrayList<Personal> personal);
}
