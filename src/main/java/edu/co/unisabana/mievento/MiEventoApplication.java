package edu.co.unisabana.mievento;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

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
import java.util.Objects;

@SpringBootApplication
public class MiEventoApplication {
	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private IPersonalRepository personalRepository;
	private static final Logger log = LoggerFactory.getLogger(MiEventoApplication.class);
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MiEventoApplication.class, args);
	/* 	ClassLoader classLoader = MiEventoApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("mievento-fc0b2-firebase-adminsdk-5neht-1de4a61a28.json")).getFile());
		FileInputStream serviceAccount =
				new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://mievento-fc0b2-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);*/
		
		

	}
	@Bean
	CommandLineRunner init(){
		return args -> {
			clientRepository.findAll().forEach(cliente-> {
				log.info(cliente.getNombre());
				log.info(personalRepository.findAll().toString());
			});
		};
	}
}
