package edu.co.unisabana.mievento.entities.reserva.evento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public abstract class Evento {
    @Id
    private Long idEvento;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String tipo; // Podría ser "Concierto", "Conferencia", "Fiesta", etc.
    private int capacidadMaxima;
    public Evento(Long idEvento, String nombre, String descripcion, String fecha, String horaInicio, String horaFin,
            String tipo, int capacidadMaxima) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
    }
}
