package edu.co.unisabana.mievento.entities.usuario;

import edu.co.unisabana.mievento.entities.personal.Personal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public ArrayList<Personal> getPersonal() {
        return personal;
    }
    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    @OneToMany
    private ArrayList<Personal> personal;
}
