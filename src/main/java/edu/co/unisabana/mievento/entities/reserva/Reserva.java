package edu.co.unisabana.mievento.entities.reserva;

import java.util.Date;

import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.lugar.Lugar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Table(name = "RESERVA")
@Entity
public class Reserva {
    @Id
    @Column(name = "id")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "idLugar")
    private Lugar lugar;

    private Evento evento;
    private String musica;
    private String comida;
    private String seguridad;
    private String direccion;
    private String fecha;
}
