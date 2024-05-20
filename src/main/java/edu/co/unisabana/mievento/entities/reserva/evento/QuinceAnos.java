package edu.co.unisabana.mievento.entities.reserva.evento;


import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalArtisticoQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalCocinaQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalLogisticaQuinceAnos;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DiscriminatorValue(value="QuinceAnos")
public class QuinceAnos extends Evento{
private String cumpleanera;
    @Transient
    private final PersonalArtisticoQuinceAnos personalArtisticoQuinceAnos= new PersonalArtisticoQuinceAnos();
    @Transient
    private final PersonalCocinaQuinceAnos personalCocinaQuinceAnos= new PersonalCocinaQuinceAnos();
    @Transient
    private final PersonalLogisticaQuinceAnos personalLogisticaQuinceAnos= new PersonalLogisticaQuinceAnos();


    @Override
    public void prepararLogistica(int capacidadMaxima) {
        List<Personal> personalLogistica;
        if (capacidadMaxima<200){
            personalLogistica = personalLogisticaQuinceAnos
                    .obtenerPersonalPequeno(this.getAdministrador()
                            .getPersonal());
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            personalLogistica = personalLogisticaQuinceAnos
                    .obtenerPersonalMediano(this.getAdministrador()
                            .getPersonal());
        }else {
            personalLogistica = personalLogisticaQuinceAnos.obtenerPersonalGrande(this.getAdministrador().getPersonal());
        }
        for (Personal personal : personalLogistica) {
            personal.setDisponible(false);
            personal.getEventos().add(this);

        }
        this.getPersonal().addAll(personalLogistica);
    }

    @Override
    public void prepararCocina(TipoComida tipoComida) {
        List<Personal> personalCocina;
        if(tipoComida.equals(TipoComida.BASICO)){
            personalCocina = personalCocinaQuinceAnos.obtenerPersonalBasico(this.getAdministrador().getPersonal());
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            personalCocina = personalCocinaQuinceAnos.obtenerPersonalFuerte(this.getAdministrador().getPersonal());
        }else {
            personalCocina = new ArrayList<>();
        }
        for (Personal personal : personalCocina) {
            personal.setDisponible(false);
            personal.getEventos().add(this);

        }
        this.getPersonal().addAll(personalCocina);
    }

    @Override
    public void prepararArtistas(TipoMusica tipoMusica) {
        List<Personal> personalArtistas;
        if (tipoMusica.equals(TipoMusica.OCHENTAS)){
            personalArtistas = personalArtisticoQuinceAnos.obtenerPersonalOchentas(this.getAdministrador().getPersonal());
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            personalArtistas = personalArtisticoQuinceAnos.obtenerPersonalUrbana(this.getAdministrador().getPersonal());
        }else {
            personalArtistas = personalArtisticoQuinceAnos.obtenerPersonalClasica(this.getAdministrador().getPersonal());
        }
        for (Personal personal : personalArtistas) {
            personal.setDisponible(false);
            personal.getEventos().add(this);

        }
        this.getPersonal().addAll(personalArtistas);
    }
}
