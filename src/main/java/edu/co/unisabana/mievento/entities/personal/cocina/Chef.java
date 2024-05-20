package edu.co.unisabana.mievento.entities.personal.cocina;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chef extends Cocina{
    private TipoComida tipoComida;
    private boolean pastelBoda;
    public Chef(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, String especialidad, boolean pastelBoda) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, especialidad);
        this.tipoComida = tipoComida;
        this.pastelBoda = pastelBoda;
    }

}
