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

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    @OneToMany
    private ArrayList<Personal> personal;
}
