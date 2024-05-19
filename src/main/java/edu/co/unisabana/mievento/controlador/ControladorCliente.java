package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.Reserva;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.factory.FabricaEventos;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ControladorCliente {
    private FabricaEventos fabricaEventos;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IPersonalRepository PersonalRepository;
    
    @PostMapping(path = "/reserva/guardar")
    public ResponseEntity<String> guardarReserva(@RequestBody Reserva reserva) {
        //servicioReserva.guardarOEditarReserva(reserva);
        Evento eventoListo= fabricaEventos.prepararEvento(reserva.getEvento());
        reserva.setEvento(eventoListo);
        return new ResponseEntity<>("Reserva guardada con éxito", HttpStatus.CREATED);
    }

    /*
    // Endpoints para reservas
    @GetMapping(path = "/reservas/todos")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        //List<Reserva> reservas = servicioReserva.obtenerReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable("id") Long id) {
        //Reserva reserva = servicioReserva.obtenerReservaPorId(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    

    @PutMapping(path = "/reserva/modificar")
    public ResponseEntity<String> modificarReserva(@RequestBody Reserva reserva) {
        //servicioReserva.guardarOEditarReserva(reserva);
        return new ResponseEntity<>("Reserva modificada con éxito", HttpStatus.OK);
    }

    @DeleteMapping(path = "/reserva/delete/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable("id") Long id) {
        //servicioReserva.eliminarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
     */

    // Endpoints para usuarios


}