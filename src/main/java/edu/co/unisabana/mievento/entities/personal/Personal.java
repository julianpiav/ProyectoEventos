package edu.co.unisabana.mievento.entities.personal;

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
    private int experienciaAños;
    @ManyToOne
    private Administrador administrador;
    @ManyToMany(mappedBy = "personal")
    private List<Evento> eventos;
}
