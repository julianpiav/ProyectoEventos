package edu.co.unisabana.mievento.entities.personal.cocina;


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
public class Chef extends Cocina{
    private TipoComida tipoComida;
    private boolean pastelBoda;
}
