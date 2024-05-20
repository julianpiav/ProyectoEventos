package edu.co.unisabana.mievento.entities.personal.artista;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Musico extends Artista {
    private String instrumentoPrincipal;
    private TipoMusica generoMusical;

    public Musico(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAnos, String instrumentoPrincipal, TipoMusica generoMusical) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAnos, null, null, null, null);
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.generoMusical = generoMusical;
    }

}
