package edu.co.unisabana.mievento.entities.reserva.evento;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor




public class Rumba extends Evento{

    @Override
    public void identificarLogistica() {

    }

    @Override
    public void identificarCocina() {

    }

    @Override
    public void identificarPersonal() {

    }
}
