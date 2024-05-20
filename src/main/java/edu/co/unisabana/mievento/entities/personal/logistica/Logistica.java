package edu.co.unisabana.mievento.entities.personal.logistica;

import edu.co.unisabana.mievento.entities.personal.Personal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Logistica extends Personal {

    private ArrayList<String> implementos;

    public Logistica(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAños, ArrayList<String> implementos) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAños, null, null);
        this.implementos = implementos;
    }


}
