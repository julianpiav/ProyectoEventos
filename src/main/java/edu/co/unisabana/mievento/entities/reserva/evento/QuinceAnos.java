package edu.co.unisabana.mievento.entities.reserva.evento;


import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalArtisticoQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalCocinaQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalLogisticaQuinceAnos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class QuinceAnos extends Evento{
private String cumpleanera;
    private final PersonalArtisticoQuinceAnos personalArtisticoQuinceAnos= new PersonalArtisticoQuinceAnos();
    private final PersonalCocinaQuinceAnos personalCocinaQuinceAnos= new PersonalCocinaQuinceAnos();
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
            personal.getEventos().add(this);
            System.out.println(personal.getCargo());

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
            personal.getEventos().add(this);
            System.out.println(personal.getCargo());

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
            personal.getEventos().add(this);
            System.out.println(personal.getCargo());

        }
        this.getPersonal().addAll(personalArtistas);
    }
}
