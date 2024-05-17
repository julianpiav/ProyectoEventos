package edu.co.unisabana.mievento.entities.usuario;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
public class Administrador extends Usuario {

    public Administrador(String nombre, String apellido, int edad) {
        super(edad, edad, apellido, nombre, apellido, apellido, apellido, apellido);
        //TODO Auto-generated constructor stub
    }
}
