package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Artista extends Personal {
    private String generoArtistico; // Podría ser "Música", "Danza", "Magia", etc.
    private String estilo; // Por ejemplo, si el género artístico es "Música", el estilo podría ser "Rock", "Pop", "Clásico", etc.
}
