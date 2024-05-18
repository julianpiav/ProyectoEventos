package edu.co.unisabana.mievento.entities.reserva;

import java.util.Date;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.Artista;
import edu.co.unisabana.mievento.entities.personal.cocina.Cocina;
import edu.co.unisabana.mievento.entities.personal.logistica.Logistica;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.lugar.Lugar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "RESERVA")
@Entity

public class Reserva {
    @Id
    private Long idReserva;
    private String lugar;
    private String tipoEvento;
    private String musica;
    private String comida;
    private String seguridad;
    private String direccion;
    private String fecha;
    protected String metodoPago;
}
