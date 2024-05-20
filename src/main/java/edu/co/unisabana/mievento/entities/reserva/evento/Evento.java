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

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boda.class, name = "Boda"),
        @JsonSubTypes.Type(value = QuinceAnos.class, name = "QuinceAnos"),
        @JsonSubTypes.Type(value = Rumba.class, name = "Rumba")
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
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "evento_personal",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "personal_id"))
    private List<Personal> personal= new ArrayList<>();
    @OneToOne
    private Reserva reserva;

    public abstract void prepararLogistica(int capacidadMaxima);
    public abstract void prepararCocina(TipoComida tipoComida);
    public abstract void prepararArtistas(TipoMusica tipoMusica);

}
