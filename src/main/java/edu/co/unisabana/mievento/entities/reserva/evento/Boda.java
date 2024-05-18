package edu.co.unisabana.mievento.entities.reserva.evento;

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
public class Boda extends Evento {
    private String pareja1;
    private String pareja2;
    private String padrino;
    private String madrina;
    private String tema; // Podría ser "Playa", "Rústico", "Elegante", etc.
    private boolean cateringIncluido;
}
