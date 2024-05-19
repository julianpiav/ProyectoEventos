package edu.co.unisabana.mievento.entities.reserva.evento;

import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalArtisticoBoda;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalCocinaBoda;
import edu.co.unisabana.mievento.factory.personalBoda.PersonalLogisticaBoda;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class Boda extends Evento {
    public String getPareja1() {
                return pareja1;
        }

        public void setPareja1(String pareja1) {
                this.pareja1 = pareja1;
        }

        public String getPareja2() {
                return pareja2;
        }

        public void setPareja2(String pareja2) {
                this.pareja2 = pareja2;
        }

        public String getPadrino() {
                return padrino;
        }

        public void setPadrino(String padrino) {
                this.padrino = padrino;
        }

        public String getMadrina() {
                return madrina;
        }

        public void setMadrina(String madrina) {
                this.madrina = madrina;
        }

        public String getTema() {
                return tema;
        }

        public void setTema(String tema) {
                this.tema = tema;
        }

        public boolean isCateringIncluido() {
                return cateringIncluido;
        }

        public void setCateringIncluido(boolean cateringIncluido) {
                this.cateringIncluido = cateringIncluido;
        }

        public PersonalArtisticoBoda getPersonalArtisticoBoda() {
                return personalArtisticoBoda;
        }

        public PersonalLogisticaBoda getPersonalLogisticaBoda() {
                return personalLogisticaBoda;
        }

        public PersonalCocinaBoda getPersonalCocinaBoda() {
                return personalCocinaBoda;
        }

private String pareja1;
    private String pareja2;
    private String padrino;
    private String madrina;
    private String tema; // Podría ser "Playa", "Rústico", "Elegante", etc.
    private boolean cateringIncluido;
    private final PersonalArtisticoBoda personalArtisticoBoda= new PersonalArtisticoBoda();
    private final PersonalLogisticaBoda personalLogisticaBoda= new PersonalLogisticaBoda();
    private final PersonalCocinaBoda personalCocinaBoda= new PersonalCocinaBoda();


    @Override
    public void prepararLogistica(int capacidadMaxima) {
        if (capacidadMaxima<200){
            this.getPersonal()
                    .addAll(personalLogisticaBoda
                            .obtenerPersonalPequeno(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        } else if (capacidadMaxima<1000 && capacidadMaxima>200) {
            this.getPersonal()
                    .addAll(personalLogisticaBoda
                            .obtenerPersonalMediano(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else {
            this.getPersonal().addAll(personalLogisticaBoda
                    .obtenerPersonalGrande(this.getAdministrador()
                            .getPersonal()));
        }
    }

    @Override
    public void prepararCocina(TipoComida tipoComida) {
        if(tipoComida.equals(TipoComida.BASICO)){
            this.getPersonal()
                    .addAll(personalCocinaBoda
                            .obtenerPersonalBasico(this.getAdministrador()
                                    .getPersonal()
                            )
                    );
        }else if(tipoComida.equals(TipoComida.FUERTE)){
            this.getPersonal().addAll(personalCocinaBoda
                    .obtenerPersonalFuerte(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }

    @Override
    public void prepararArtistas(TipoMusica tipoMusica) {
        if (tipoMusica.equals(TipoMusica.OCHENTAS)){
            this.getPersonal().addAll(personalArtisticoBoda
                    .obtenerPersonalOchentas(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else if(tipoMusica.equals(TipoMusica.URBANA)){
            this.getPersonal().addAll(personalArtisticoBoda
                    .obtenerPersonalUrbana(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }else {
            this.getPersonal().addAll(personalArtisticoBoda
                    .obtenerPersonalClasica(this.getAdministrador()
                            .getPersonal()
                    )
            );
        }
    }
}
