package edu.co.unisabana.mievento.entities.personal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONAL")
@Entity
public class Personal {
    @Id
    private Integer idPersonal;
    private String nombre;
    private String apellido;
    private String contacto;
    private boolean disponible;
    public Integer getIdPersonal() {
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
