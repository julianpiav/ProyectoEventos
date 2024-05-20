package edu.co.unisabana.mievento.entities.reserva.lugar;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Lugar {
    @Id
    private Long idLugar;
    private String nombre;
    private String direccion;
    private int capacidad;
    private boolean disponibilidad;
    private String descripcion;
}
