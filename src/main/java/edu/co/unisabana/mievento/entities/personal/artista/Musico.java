package edu.co.unisabana.mievento.entities.personal.artista;

import edu.co.unisabana.mievento.entities.personal.Personal;
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

}
