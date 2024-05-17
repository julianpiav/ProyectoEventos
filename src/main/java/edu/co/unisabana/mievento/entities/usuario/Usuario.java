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
    public int getDocumento() {
        return documento;
    }
    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCorreo() {
        return correo;
    }
    public String getMetodopago() {
        return metodopago;
    }
    private String metodopago;
}