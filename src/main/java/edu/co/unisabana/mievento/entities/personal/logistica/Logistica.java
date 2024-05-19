package edu.co.unisabana.mievento.entities.personal.logistica;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Logistica extends Personal {
    public ArrayList<String> getImplementos() {
        return implementos;
    }

    public void setImplementos(ArrayList<String> implementos) {
        this.implementos = implementos;
    }

    private ArrayList<String> implementos;
}
