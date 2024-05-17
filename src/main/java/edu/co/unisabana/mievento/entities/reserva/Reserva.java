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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idLugar", nullable = false)
    private Lugar lugar;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEvento", nullable = false)
    private Evento evento;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersonal", nullable = true)
    private Personal logistica;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idArtista", nullable = true)
    private Artista musica;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCocina", nullable = true)
    private Cocina comida;

    private String fecha;
}
