package edu.co.unisabana.mievento.entities.personal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Personal {
    @Id
    private Long idPersonal;
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;

}
