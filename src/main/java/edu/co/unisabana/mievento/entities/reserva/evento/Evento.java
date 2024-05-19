package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Evento {
    @Id
    private Long idEvento;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private int capacidadMaxima;
    private String tipoMusica;
    private boolean dj;
    private boolean orquesta;
    @OneToMany
    private ArrayList<Personal> personal;

    public abstract void prepararLogistica();
    public abstract void prepararCocina();
    public abstract void prepararPersonal();

}
