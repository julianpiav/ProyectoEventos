package edu.co.unisabana.mievento.entities.personal.logistica;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Todero extends Logistica{
    public Todero(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAnos, ArrayList<String> implementos) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAnos, implementos);
    }

}
