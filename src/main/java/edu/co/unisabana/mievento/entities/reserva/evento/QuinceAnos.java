package edu.co.unisabana.mievento.entities.reserva.evento;


import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalArtisticoQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalCocinaQuinceAnos;
import edu.co.unisabana.mievento.factory.personalQuinceAnos.PersonalLogisticaQuinceAnos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor




public class QuinceAnos extends Evento{
    private String cumpleañera;
    private final PersonalArtisticoQuinceAnos personalArtisticoQuinceAnos= new PersonalArtisticoQuinceAnos();
    private final PersonalCocinaQuinceAnos personalCocinaQuinceAnos= new PersonalCocinaQuinceAnos();
    private final PersonalLogisticaQuinceAnos personalLogisticaQuinceAnos= new PersonalLogisticaQuinceAnos();


    @Override
    public void prepararLogistica(int capacidadMaxima) {
        if (capacidadMaxima<200){
            this.getPersonal()
                    .addAll(personalLogisticaQuinceAnos
                            .obtenerPersonalPequeno(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            this.getPersonal()
                    .addAll(personalLogisticaQuinceAnos
                            .obtenerPersonalMediano(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else {
            this.getPersonal().addAll(personalLogisticaQuinceAnos
                    .obtenerPersonalGrande(this.getAdministrador()
                            .getPersonal()));
        }
    }

    @Override
    public void prepararCocina(TipoComida tipoComida) {
        if(tipoComida.equals(TipoComida.BASICO)){
            this.getPersonal()
                    .addAll(personalCocinaQuinceAnos
                            .obtenerPersonalBasico(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            this.getPersonal().addAll(personalCocinaQuinceAnos
                    .obtenerPersonalFuerte(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }

    @Override
    public void prepararArtistas(TipoMusica tipoMusica) {
        if (tipoMusica.equals(TipoMusica.OCHENTAS)){
            this.getPersonal().addAll(personalArtisticoQuinceAnos
                    .obtenerPersonalOchentas(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            this.getPersonal().addAll(personalArtisticoQuinceAnos
                    .obtenerPersonalUrbana(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else {
            this.getPersonal().addAll(personalArtisticoQuinceAnos
                    .obtenerPersonalClasica(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }
}
