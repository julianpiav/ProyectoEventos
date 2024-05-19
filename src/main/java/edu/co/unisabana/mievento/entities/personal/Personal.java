package edu.co.unisabana.mievento.entities.personal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer idPersonal;
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;
}
