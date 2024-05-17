package edu.co.unisabana.mievento.entities.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public abstract class Usuario {
    @Id
    private int documento;
    private int edad;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String metodopago;
}
