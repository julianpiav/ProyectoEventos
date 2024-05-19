package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public abstract class Artista extends Personal {
    public int getIdArtista() {
        return idArtista;
    }
    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }
    public String getGeneroArtistico() {
        return generoArtistico;
    }
    public void setGeneroArtistico(String generoArtistico) {
        this.generoArtistico = generoArtistico;
    }
    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    public int getExperienciaAños() {
        return experienciaAños;
    }
    public void setExperienciaAños(int experienciaAños) {
        this.experienciaAños = experienciaAños;
    }
    private int idArtista;
    private String generoArtistico; // Podría ser "Música", "Danza", "Magia", etc.
    private String estilo; // Por ejemplo, si el género artístico es "Música", el estilo podría ser "Rock", "Pop", "Clásico", etc.
    private int experienciaAños;
}
