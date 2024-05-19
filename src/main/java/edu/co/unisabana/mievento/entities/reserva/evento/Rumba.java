package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalArtisticoRumba;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalCocinaRumba;
import edu.co.unisabana.mievento.factory.personalRumba.PersonalLogisticaRumba;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor




public class Rumba extends Evento{


    private final PersonalArtisticoRumba personalArtisticoRumba= new PersonalArtisticoRumba();
    private final PersonalCocinaRumba personalCocinaRumba= new PersonalCocinaRumba();
    private final PersonalLogisticaRumba personalLogisticaRumba= new PersonalLogisticaRumba();


    @Override
    public void prepararLogistica(int capacidadMaxima) {
        if (capacidadMaxima<200){
            this.getPersonal()
                    .addAll(personalLogisticaRumba
                            .obtenerPersonalPequeno(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            this.getPersonal()
                    .addAll(personalLogisticaRumba
                            .obtenerPersonalMediano(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else {
            this.getPersonal().addAll(personalLogisticaRumba
                    .obtenerPersonalGrande(this.getAdministrador()
                            .getPersonal()));
        }
    }

    @Override
    public void prepararCocina(TipoComida tipoComida) {
        if(tipoComida.equals(TipoComida.BASICO)){
            this.getPersonal()
                    .addAll(personalCocinaRumba
                            .obtenerPersonalBasico(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            this.getPersonal().addAll(personalCocinaRumba
                    .obtenerPersonalFuerte(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }

    @Override
    public void prepararArtistas(TipoMusica tipoMusica) {
        if (tipoMusica.equals(TipoMusica.OCHENTAS)){
            this.getPersonal().addAll(personalArtisticoRumba
                    .obtenerPersonalOchentas(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            this.getPersonal().addAll(personalArtisticoRumba
                    .obtenerPersonalUrbana(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else {
            this.getPersonal().addAll(personalArtisticoRumba
                    .obtenerPersonalClasica(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }
}
