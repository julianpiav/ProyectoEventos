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
    public void prepararLogistica() {

    }

    @Override
    public void prepararCocina() {

    }

    @Override
    public void prepararPersonal() {

    }
}
