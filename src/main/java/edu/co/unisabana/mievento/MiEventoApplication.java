package edu.co.unisabana.mievento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
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

			// Crea una nueva instancia de Personal
			Personal personal1 = new Chef();
			personal1.setNombre("Juan");
			personal1.setApellido("Pérez");
			personal1.setContacto("juan.perez@example.com");
			personal1.setDisponible(true);
			personal1.setCargo("Cocinero");

			// Guarda el personal en la base de datos
			personalRepository.save(personal1);

			// Crea más personal
			Personal personal2 = new Personal();
			personal2.setNombre("María");
			personal2.setApellido("Rodríguez");
			personal2.setContacto("maria.rodriguez@example.com");
			personal2.setDisponible(true);
			personal2.setCargo("Mesera");

			Personal personal3 = new Personal();
			personal3.setNombre("Carlos");
			personal3.setApellido("Gómez");
			personal3.setContacto("carlos.gomez@example.com");
			personal3.setDisponible(true);
			personal3.setCargo("Bartender");

			// Guarda el personal en la base de datos
			personalRepository.save(personal2);
			personalRepository.save(personal3);

			// Crea una nueva instancia de Administrador
			Administrador administrador = new Administrador();
			administrador.setDocumento(123456789);
			administrador.setNombre("Ana");
			administrador.setApellido("Gómez");
			administrador.setTelefono("3001234567");
			administrador.setCorreo("ana.gomez@example.com");

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
