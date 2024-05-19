package edu.co.unisabana.mievento.entities.personal.cocina;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Chef extends Cocina{
    public TipoComida getTipoComida() {
        return tipoComida;
    }
    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }
    public boolean isPastelBoda() {
        return pastelBoda;
    }
    public void setPastelBoda(boolean pastelBoda) {
        this.pastelBoda = pastelBoda;
    }
    private TipoComida tipoComida;
    private boolean pastelBoda;
}
