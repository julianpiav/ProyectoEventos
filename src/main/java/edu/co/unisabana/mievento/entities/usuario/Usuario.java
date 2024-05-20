package edu.co.unisabana.mievento.entities.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
    @Id
    protected int documento;
    protected int edad;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;
    protected String correo;
}
