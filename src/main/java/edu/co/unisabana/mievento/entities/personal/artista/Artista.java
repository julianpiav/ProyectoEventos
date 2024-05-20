package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Artista extends Personal {
    private String generoArtistico; // Podría ser "Música", "Danza", "Magia", etc.
    private String estilo; // Por ejemplo, si el género artístico es "Música", el estilo podría ser "Rock", "Pop", "Clásico", etc.


    public Artista(Administrador administrador, String cargo, String apellido, String contacto, boolean disponible, List<Evento> eventos, int experienciaAnos, String nombre, Long idPersonal, String estilo, String generoArtistico) {
        super(administrador, cargo, apellido, contacto, disponible, eventos, experienciaAnos, nombre, idPersonal);
        this.estilo = estilo;
        this.generoArtistico = generoArtistico;
    }

    public Artista(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAnos, Administrador administrador, List<Evento> eventos, String estilo, String generoArtistico) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAnos, administrador, eventos);
        this.estilo = estilo;
        this.generoArtistico = generoArtistico;
    }
}
