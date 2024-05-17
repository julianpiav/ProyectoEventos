package edu.co.unisabana.mievento.entities.reserva.evento;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Boda extends Evento {
    private String pareja1;
    private String pareja2;
    private String padrino;
    private String madrina;
    private String tema; // Podría ser "Playa", "Rústico", "Elegante", etc.
    private boolean cateringIncluido;
    public Boda(Long idEvento, String nombre, String descripcion, String fecha, String horaInicio, String horaFin,
            String tipo, int capacidadMaxima, String pareja1, String pareja2, String padrino, String madrina,
            String tema, boolean cateringIncluido) {
        super(idEvento, nombre, descripcion, fecha, horaInicio, horaFin, tipo, capacidadMaxima);
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.padrino = padrino;
        this.madrina = madrina;
        this.tema = tema;
        this.cateringIncluido = cateringIncluido;
    }
    
}
