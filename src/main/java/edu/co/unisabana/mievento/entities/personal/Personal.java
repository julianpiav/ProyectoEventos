package edu.co.unisabana.mievento.entities.personal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonal;
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;
    private String cargo;
    protected int experienciaAnos;
    @JsonBackReference
    @ManyToOne
    private Administrador administrador;
    @ManyToMany(mappedBy = "personal")
    private List<Evento> eventos;

    public Personal(Administrador administrador, String cargo, String apellido, String contacto, boolean disponible, List<Evento> eventos, int experienciaAños, String nombre, Long idPersonal) {
        this.administrador = administrador;
        this.cargo = cargo;
        this.apellido = apellido;
        this.contacto = contacto;
        this.disponible = disponible;
        this.eventos = eventos;
        this.experienciaAnos = experienciaAños;
        this.nombre = nombre;
        this.idPersonal = idPersonal;
    }
}
