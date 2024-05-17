package edu.co.unisabana.mievento.entities.personal.logistica;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public abstract class Logistica extends Personal {
    private String areaEspecializacion; // Podría ser "Transporte", "Montaje", "Desmontaje", etc.
}
