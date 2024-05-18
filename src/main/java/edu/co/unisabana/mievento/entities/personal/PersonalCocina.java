package edu.co.unisabana.mievento.entities.personal;

import edu.co.unisabana.mievento.entities.personal.cocina.Chef;

import java.util.ArrayList;

public interface PersonalCocina {
    public void agregarPersonalBasico(ArrayList<Chef> chefs);
    public void agregarPersonalFuerte(ArrayList<Chef> chefs);
}
