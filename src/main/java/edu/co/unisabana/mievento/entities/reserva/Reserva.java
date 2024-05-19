package edu.co.unisabana.mievento.entities.reserva;

import java.util.Date;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.Artista;
import edu.co.unisabana.mievento.entities.personal.cocina.Cocina;
import edu.co.unisabana.mievento.entities.personal.logistica.Logistica;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.lugar.Lugar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "RESERVA")
@Entity

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private String lugar;
    private String musica;
    private String comida;
    private String direccion;
    private String fecha;
    protected String metodoPago;
    @OneToOne
    private Evento evento;

}
