package edu.co.unisabana.mievento.entities.usuario;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "documento")
public class Cliente extends Usuario{
    private String metodopago;
    @JsonManagedReference(value = "cliente-reserva")
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas= new ArrayList<>();

}
