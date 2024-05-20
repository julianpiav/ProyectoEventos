package edu.co.unisabana.mievento.entities.personal.cocina;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cocina extends Personal {

    private String especialidad;

    public Cocina(Long idPersonal, String especialidad, String apellido, String contacto, boolean disponible, String cargo, String s) {
        this.especialidad = especialidad;
    }

    public Cocina(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAños, Administrador administrador, List<Evento> eventos, String especialidad) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAños, administrador, eventos);
        this.especialidad = especialidad;
    }
}
