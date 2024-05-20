package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalArtisticoRumba;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalCocinaRumba;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalLogisticaRumba;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue(value = "Rumba")

public class Rumba extends Evento{

    @Transient
    private final PersonalArtisticoRumba personalArtisticoRumba= new PersonalArtisticoRumba();
    @Transient
    private final PersonalCocinaRumba personalCocinaRumba= new PersonalCocinaRumba();
    @Transient
    private final PersonalLogisticaRumba personalLogisticaRumba= new PersonalLogisticaRumba();


    @Override
    public void prepararLogistica(int capacidadMaxima) {
        List<Personal> personalLogistica;
        if (capacidadMaxima<200){
            personalLogistica = personalLogisticaRumba
                    .obtenerPersonalPequeno(this.getAdministrador()
                            .getPersonal());
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            personalLogistica = personalLogisticaRumba
                    .obtenerPersonalMediano(this.getAdministrador()
                            .getPersonal());
        }else {
            personalLogistica = personalLogisticaRumba.obtenerPersonalGrande(this.getAdministrador().getPersonal());
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
            personalCocina = personalCocinaRumba.obtenerPersonalBasico(this.getAdministrador().getPersonal());
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            personalCocina = personalCocinaRumba.obtenerPersonalFuerte(this.getAdministrador().getPersonal());
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
            personalArtistas = personalArtisticoRumba.obtenerPersonalOchentas(this.getAdministrador().getPersonal());
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            personalArtistas = personalArtisticoRumba.obtenerPersonalUrbana(this.getAdministrador().getPersonal());
        }else {
            personalArtistas = personalArtisticoRumba.obtenerPersonalClasica(this.getAdministrador().getPersonal());
        }
        for (Personal personal : personalArtistas) {
            personal.setDisponible(false);
            personal.getEventos().add(this);
        }
        this.getPersonal().addAll(personalArtistas);
    }
}
