package edu.co.unisabana.mievento.entities.reserva.evento;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.entities.reserva.Reserva;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boda.class, name = "boda"),
        @JsonSubTypes.Type(value = QuinceAnos.class, name = "quinceAnos"),
        @JsonSubTypes.Type(value = Rumba.class, name = "rumba")
})
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Personal> personal;
    @OneToOne
    private Reserva reserva;

    public abstract void prepararLogistica(int capacidadMaxima);
    public abstract void prepararCocina(TipoComida tipoComida);
    public abstract void prepararArtistas(TipoMusica tipoMusica);

}
