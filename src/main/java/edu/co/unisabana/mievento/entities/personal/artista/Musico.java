package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class Musico extends Artista {
    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }
    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        this.instrumentoPrincipal = instrumentoPrincipal;
    }
    public TipoMusica getGeneroMusical() {
        return generoMusical;
    }
    public void setGeneroMusical(TipoMusica generoMusical) {
        this.generoMusical = generoMusical;
    }
    private String instrumentoPrincipal;
    private TipoMusica generoMusical;

}
