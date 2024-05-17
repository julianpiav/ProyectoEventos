package edu.co.unisabana.mievento.entities.reserva;

import java.util.Date;

import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.lugar.Lugar;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


@Entity
public class Reserva {
    private Lugar lugar;
    private Evento evento;
    private Date fecha;
    private Float precio;

}
