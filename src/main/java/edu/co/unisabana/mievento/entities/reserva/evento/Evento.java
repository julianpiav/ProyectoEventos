package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
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
    private TipoMusica tipoMusica;
    private TipoComida tipoComida;
    @ManyToOne
    private Administrador administrador;
    @OneToMany
    private ArrayList<Personal> personal;

    public abstract void prepararLogistica(int capacidadMaxima);
    public abstract void prepararCocina(TipoComida tipoComida);
    public abstract void prepararArtistas(TipoMusica tipoMusica);

}
