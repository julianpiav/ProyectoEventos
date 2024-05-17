package edu.co.unisabana.mievento.entities.usuario;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter



public class Administrador extends Usuario {
    public Administrador(int documento, int edad, String nombre, String apellido, String telefono, String direccion,
            String correo, String metodopago) {
        super();
    }
}
