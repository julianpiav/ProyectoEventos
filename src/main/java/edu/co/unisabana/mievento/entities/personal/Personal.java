package edu.co.unisabana.mievento.entities.personal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONAL")
@Entity
public class Personal {
    @Id
    private Integer idPersonal;
    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;
    public Integer getidPersonal() {
        return idPersonal;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getContacto() {
        return contacto;
    }
    public boolean isDisponible() {
        return disponible;
    }
    

}
