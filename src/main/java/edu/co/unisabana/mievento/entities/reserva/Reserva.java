package edu.co.unisabana.mievento.entities.reserva;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.Artista;
import edu.co.unisabana.mievento.entities.personal.cocina.Cocina;
import edu.co.unisabana.mievento.entities.personal.logistica.Logistica;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.reserva.lugar.Lugar;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idReserva")
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
    @JsonBackReference(value = "cliente-reserva")
    @ManyToOne
    private Cliente cliente;

    @JsonBackReference(value = "evento-reserva")
    @OneToOne (cascade = CascadeType.ALL)
    private Evento evento;

}
