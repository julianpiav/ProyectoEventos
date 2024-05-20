package edu.co.unisabana.mievento.entities.usuario;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Administrador extends Usuario{
    @JsonManagedReference
    @OneToMany(mappedBy = "administrador")
    private List<Personal> personal = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "administrador")
    private List<Evento> eventos = new ArrayList<>();

    public Administrador(int documento, String nombre, String apellido, String telefono, String correo, List<Personal> personal) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.personal = personal;
    }

}
