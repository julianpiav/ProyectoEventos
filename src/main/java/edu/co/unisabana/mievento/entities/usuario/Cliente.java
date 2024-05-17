package edu.co.unisabana.mievento.entities.usuario;

import java.util.ArrayList;

import edu.co.unisabana.mievento.entities.reserva.Reserva;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "CLIENTES")
@Entity
public class Cliente {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String metodopago;
    public int getDocumento() {
        return documento;
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

}
