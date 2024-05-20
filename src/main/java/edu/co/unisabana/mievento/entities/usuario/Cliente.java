package edu.co.unisabana.mievento.entities.usuario;

import java.util.ArrayList;
import java.util.List;

import edu.co.unisabana.mievento.entities.reserva.Reserva;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas= new ArrayList<>();

}
