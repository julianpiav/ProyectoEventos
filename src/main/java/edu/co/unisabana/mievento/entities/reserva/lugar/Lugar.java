package edu.co.unisabana.mievento.entities.reserva.lugar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
public abstract class Lugar {
    @Id
    private Long idLugar;
    private String nombre;
    private String direccion;
    private int capacidad;
    private Lugar tipo; // Podría ser "Interior", "Exterior", "Virtual", etc.
    private boolean disponibilidad;
    private String descripcion;
}
