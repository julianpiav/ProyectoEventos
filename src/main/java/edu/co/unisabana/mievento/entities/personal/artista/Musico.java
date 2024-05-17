package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Musico extends Personal {
    private String instrumentoPrincipal;
    private String generoMusical; // Podría ser "Rock", "Pop", "Clásico", etc.
}
