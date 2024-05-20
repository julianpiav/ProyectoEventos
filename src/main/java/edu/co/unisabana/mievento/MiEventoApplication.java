package edu.co.unisabana.mievento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
import edu.co.unisabana.mievento.entities.personal.cocina.TipoComida;
import edu.co.unisabana.mievento.entities.personal.logistica.Todero;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import edu.co.unisabana.mievento.repository.IAdministradorRepository;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class MiEventoApplication {
	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private IPersonalRepository personalRepository;
	@Autowired
	private IAdministradorRepository administradorRepository;
	private static final Logger log = LoggerFactory.getLogger(MiEventoApplication.class);
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MiEventoApplication.class, args);
	}
	@Bean
    CommandLineRunner init() {
        return args -> {
            clientRepository.findAll().forEach(cliente -> {
                log.info(cliente.getNombre());
            });

            personalRepository.findAll().forEach(personal ->{
                log.info(personal.getApellido());
            });

			// Crea una nueva instancia de Administrador
			Administrador administrador = new Administrador();
			administrador.setDocumento(123456789);
			administrador.setNombre("Ana");
			administrador.setApellido("Gómez");
			administrador.setTelefono("3001234567");
			administrador.setCorreo("ana.gomez@example.com");
			// Guarda el administrador en la base de datos
			administradorRepository.save(administrador);

			// Crea una nueva instancia de Personal
			Chef personal1 = new Chef(3L, "Carlos", "Gomez", "carlos.gomez@example.com", true, "Chef", "Italiana", false);
			personal1.setNombre("Juan");
			personal1.setApellido("Pérez");
			personal1.setContacto("juan.perez@example.com");
			personal1.setDisponible(true);
			personal1.setTipoComida(TipoComida.FUERTE);
			personal1.setPastelBoda(true);
			personal1.setCargo("Cocinero");
			personal1.setAdministrador(administrador);

			// Guarda el personal en la base de datos
			personalRepository.save(personal1);

			// Crea más personal
			Musico personal2 = new Musico();
			personal2.setNombre("María");
			personal2.setApellido("Rodríguez");
			personal2.setContacto("maria.rodriguez@example.com");
			personal2.setDisponible(true);
			personal2.setGeneroMusical(TipoMusica.CLASICA);
			personal2.setInstrumentoPrincipal("Piano");
			personal2.setCargo("Musico");
			personal2.setAdministrador(administrador);
			personalRepository.save(personal2);


			Todero personal3 = new Todero();
			personal3.setNombre("Carlos");
			personal3.setApellido("Gómez");
			personal3.setContacto("carlos.gomez@example.com");
			personal3.setDisponible(true);
			personal3.setCargo("Todero");
			personal3.setAdministrador(administrador);



			// Guarda el personal en la base de datos

			personalRepository.save(personal3);



			// Añade el personal al administrador
			List<Personal> personalList = new ArrayList<>();
			personalList.add(personal1);
			personalList.add(personal2);
			personalList.add(personal3);
			administrador.setPersonal(personalList);
			// Guarda el administrador en la base de datos
			administradorRepository.save(administrador);





        };
    }
}
