package edu.co.unisabana.mievento.entities.personal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONAL")
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonal;
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;
    private String cargo;
}
