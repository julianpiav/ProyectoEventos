package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Musico extends Artista {
    private String instrumentoPrincipal;
    private TipoMusica generoMusical;

    public Musico(Long idPersonal, String nombre, String apellido, String contacto, boolean disponible, String cargo, int experienciaAños, String instrumentoPrincipal, TipoMusica generoMusical) {
        super(idPersonal, nombre, apellido, contacto, disponible, cargo, experienciaAños, null, null, null, null);
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.generoMusical = generoMusical;
    }

}
