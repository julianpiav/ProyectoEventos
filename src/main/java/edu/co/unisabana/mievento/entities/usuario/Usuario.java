package edu.co.unisabana.mievento.entities.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Usuario {
    @Id
    protected int documento;
    protected int edad;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;
    protected String correo;
    protected String metodopago;
}
