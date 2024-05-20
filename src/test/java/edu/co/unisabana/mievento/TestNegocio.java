package edu.co.unisabana.mievento;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.personal.artista.Musico;
import edu.co.unisabana.mievento.entities.personal.artista.TipoMusica;
import edu.co.unisabana.mievento.entities.personal.cocina.Chef;
import edu.co.unisabana.mievento.entities.personal.logistica.Todero;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNegocio {
    @Test
    public void crearAdministradorPrueba() {
        // Crear dos toderos
        Personal tod1 = new Todero(1L, "Juan", "Perez", "juan.perez@example.com", true, "Todero",20, new ArrayList<>());
        Personal tod2 = new Todero(2L, "Maria", "Rodriguez", "maria.rodriguez@example.com", true, "Todero",30, new ArrayList<>());

        // Crear dos chefs
        Personal chef1 = new Chef(3L, "Carlos", "Gomez", "carlos.gomez@example.com", true, "Chef", "Italiana", false);
        Personal chef2 = new Chef(4L, "Ana", "Martinez", "ana.martinez@example.com", true, "Chef", "Mexicana", true);

        // Crear dos músicos
        Personal mus1 = new Musico(5L, "Pedro", "Sanchez", "pedro.sanchez@example.com",true, "Musico", 20,"Guitarra", TipoMusica.ROCK);
        Personal mus2 = new Musico(6L, "Laura", "Garcia", "laura.garcia@example.com", true, "Musico",10, "Batería", TipoMusica.POP);

        // Crear una lista de personal
        ArrayList<Personal> personal = new ArrayList<>();
        personal.add(tod1);
        personal.add(tod2);
        personal.add(chef1);
        personal.add(chef2);
        personal.add(mus1);
        personal.add(mus2);

        // Crear un administrador con la lista de personal
        Administrador administrador = new Administrador(12345678, "Pedro", "Sanchez", "555-555-5555", "pedro.sanchez@example.com", personal);

        // Verificar que el administrador se creó correctamente
        assertEquals(12345678, administrador.getDocumento());
        assertEquals("Pedro", administrador.getNombre());
        assertEquals("Sanchez", administrador.getApellido());
        assertEquals("555-555-5555", administrador.getTelefono());
        assertEquals("pedro.sanchez@example.com", administrador.getCorreo());
        assertEquals(6, administrador.getPersonal().size());
    }
}

