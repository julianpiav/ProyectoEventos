package edu.co.unisabana.mievento.entities.personal;

import edu.co.unisabana.mievento.entities.personal.logistica.Logistica;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PersonalLogistica {
    public void agregarPersonalPequeno(ArrayList<Logistica> logisticaPequena);
    public void agregarPersonalMediano(ArrayList<Logistica> logisticaMediana) ;
    public void agregarPersonalGrande(ArrayList<Logistica> logisticaGrande);
}
