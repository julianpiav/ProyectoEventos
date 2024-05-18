package edu.co.unisabana.mievento.entities.personal;

import edu.co.unisabana.mievento.entities.personal.artista.Artista;

import java.util.ArrayList;

public interface PersonalArtistico {
    public void agregarPersonalClasica(ArrayList<Artista> artistas);
    public void agregarPersonalUrbana(ArrayList<Artista> artistas);
    public void agregarPersonalOchentas(ArrayList<Artista> artistas);
}
