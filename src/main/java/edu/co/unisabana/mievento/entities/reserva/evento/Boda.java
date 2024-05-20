package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalArtisticoBoda;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalCocinaBoda;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalLogisticaBoda;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value= "Boda")
public class Boda extends Evento {
private String pareja1;
    private String pareja2;
    private String padrino;
    private String madrina;
    private String tema; // Podría ser "Playa", "Rústico", "Elegante", etc.
    private boolean cateringIncluido;
    @Transient
    private final PersonalArtisticoBoda personalArtisticoBoda= new PersonalArtisticoBoda();
    @Transient
    private final PersonalLogisticaBoda personalLogisticaBoda= new PersonalLogisticaBoda();
    @Transient
    private final PersonalCocinaBoda personalCocinaBoda= new PersonalCocinaBoda();



    @Override
    public void prepararLogistica(int capacidadMaxima) {
        List<Personal> personalLogistica;
        for (Personal personal : this.getAdministrador().getPersonal()) {
            System.out.println(personal.toString());
            personal.getEventos().add(this);
        }
        if (capacidadMaxima<200){
            personalLogistica = personalLogisticaBoda
                    .obtenerPersonalPequeno(this.getAdministrador()
                            .getPersonal());
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            personalLogistica = personalLogisticaBoda
                    .obtenerPersonalMediano(this.getAdministrador()
                            .getPersonal());
        }else {
            personalLogistica = personalLogisticaBoda.obtenerPersonalGrande(this.getAdministrador().getPersonal());
        }
        for (Personal personal : personalLogistica) {
            personal.setDisponible(false);
            personal.getEventos().add(this);
        }
        this.getPersonal().addAll(personalLogistica);
    }

    @Override
    public void prepararCocina(TipoComida tipoComida) {
        for (Personal personal : this.getAdministrador().getPersonal()) {
            System.out.println(personal.toString());
            personal.getEventos().add(this);
        }
        List<Personal> personalCocina;
        if(tipoComida.equals(TipoComida.BASICO)){
            personalCocina = personalCocinaBoda.obtenerPersonalBasico(this.getAdministrador().getPersonal());
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            personalCocina = personalCocinaBoda.obtenerPersonalFuerte(this.getAdministrador().getPersonal());
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
            personalArtistas = personalArtisticoBoda.obtenerPersonalOchentas(this.getAdministrador().getPersonal());
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            personalArtistas = personalArtisticoBoda.obtenerPersonalUrbana(this.getAdministrador().getPersonal());
        }else {
            personalArtistas = personalArtisticoBoda.obtenerPersonalClasica(this.getAdministrador().getPersonal());
        }
        for (Personal personal : personalArtistas) {
            personal.setDisponible(false);
            personal.getEventos().add(this);

        }
        this.getPersonal().addAll(personalArtistas);
    }
}
