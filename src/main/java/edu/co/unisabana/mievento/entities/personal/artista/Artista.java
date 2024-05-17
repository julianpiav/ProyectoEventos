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
public class Artista extends Personal {
    private int idArtista;
    private String generoArtistico; // Podría ser "Música", "Danza", "Magia", etc.
    private String estilo; // Por ejemplo, si el género artístico es "Música", el estilo podría ser "Rock", "Pop", "Clásico", etc.
    private String portfolio; // Un enlace a su trabajo previo, si está disponible en línea.
    private int experienciaAños;
}
