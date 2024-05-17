package edu.co.unisabana.mievento.entities.usuario;

import java.util.ArrayList;

import edu.co.unisabana.mievento.entities.reserva.Reserva;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Table(name = "CLIENTES")
@Entity
public class Cliente extends Usuario {
    public Cliente(String nombre, String apellido, int edad) {
        super(edad, edad, apellido, nombre, apellido, apellido, apellido, apellido);
        //TODO Auto-generated constructor stub
    }

    private ArrayList<Reserva> reservas;
}
