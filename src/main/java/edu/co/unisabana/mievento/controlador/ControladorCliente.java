package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.Reserva;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.factory.FabricaEventos;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;
import edu.co.unisabana.mievento.repository.IReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ControladorCliente {
    @Autowired
    private FabricaEventos fabricaEventos;
    @Autowired
    private IReservasRepository reservasRepository;


    // Endpoints para reservas
    @GetMapping(path = "/reservas/todos")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        Iterable<Reserva> reservaIterable = reservasRepository.findAll();
        List<Reserva> reservas = new ArrayList<>();
        reservaIterable.forEach(reservas::add);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable("id") Long id) {
        Reserva reserva = reservasRepository.findById(id).orElse(null);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping(path = "/reserva/guardar")
    public ResponseEntity<String> guardarReserva(@RequestBody Reserva reserva) {
        Evento eventoListo= fabricaEventos.prepararEvento(reserva.getEvento());
        reserva.setEvento(eventoListo);
        reservasRepository.save(reserva);
        return new ResponseEntity<>("Reserva guardada con éxito", HttpStatus.CREATED);
    }

    @PutMapping(path = "/reserva/modificar")
    public ResponseEntity<String> modificarReserva(@RequestBody Reserva reserva) {
        reservasRepository.save(reserva);
        return new ResponseEntity<>("Reserva modificada con éxito", HttpStatus.OK);
    }

    @DeleteMapping(path = "/reserva/delete/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable("id") Long id) {
        reservasRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}