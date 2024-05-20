package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.Reserva;
import edu.co.unisabana.mievento.entities.reserva.evento.Evento;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.factory.FabricaEventos;
import edu.co.unisabana.mievento.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ControladorCliente {
    @Autowired
    private FabricaEventos fabricaEventos;
    @Autowired
    private IReservasRepository reservasRepository;
    @Autowired
    private IAdministradorRepository administradorRepository;
    @Autowired
    private  IClientRepository clientRepository;
    @Autowired
    private IPersonalRepository personalRepository;



    // Endpoints para reservas
    @GetMapping(path = "/reservas/todos")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        List<Reserva> reservas = (List<Reserva>) reservasRepository.findAll();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable("id") Long id) {
        Reserva reserva = reservasRepository.findById(id).orElse(null);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping(path = "/reserva/guardar")
    public ResponseEntity<String> guardarReserva(@RequestBody Reserva reserva) {
        clientRepository.save(reserva.getCliente());
        reserva.getCliente().getReservas().add(reserva);
        Administrador administrador= administradorRepository.findById(reserva.getEvento().getAdministrador().getDocumento()).orElse(null);
        reserva.getEvento().setAdministrador(administrador);
        Evento eventoListo= fabricaEventos.prepararEvento(reserva.getEvento());
        eventoListo.setReserva(reserva);
        administrador.getEventos().add(eventoListo);
        reserva.setEvento(eventoListo);
        reservasRepository.save(reserva);
        return new ResponseEntity<>("Reserva guardada con éxito", HttpStatus.CREATED);
    }

    @PutMapping(path = "/reserva/modificar")
    public ResponseEntity<String> modificarReserva(@RequestBody Reserva reserva) {
        Reserva existingReserva = reservasRepository.findById(reserva.getIdReserva()).orElse(null);
        if (existingReserva == null) {
            return new ResponseEntity<>("Reserva no encontrada", HttpStatus.NOT_FOUND);
        } else {
            existingReserva.setLugar(reserva.getLugar());
            existingReserva.setMusica(reserva.getMusica());
            existingReserva.setComida(reserva.getComida());
            existingReserva.setDireccion(reserva.getDireccion());
            existingReserva.setFecha(reserva.getFecha());
            existingReserva.setMetodoPago(reserva.getMetodoPago());
            existingReserva.setCliente(reserva.getCliente());

            Evento eventoNuevo = fabricaEventos.prepararEvento(reserva.getEvento());
            existingReserva.setEvento(eventoNuevo);
            eventoNuevo.setReserva(existingReserva);

            reservasRepository.save(existingReserva);

            return new ResponseEntity<>("Reserva modificada con éxito", HttpStatus.OK);
        }
    }


    @DeleteMapping(path = "/reserva/eliminar/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable("id") Long id) {
        Reserva existingReserva = reservasRepository.findById(id).orElse(null);
        if (existingReserva == null) {
            return new ResponseEntity<>("Reserva not found", HttpStatus.NOT_FOUND);
        }

        Cliente cliente = existingReserva.getCliente();
        cliente.getReservas().remove(existingReserva);
        clientRepository.save(cliente);

        Administrador administrador = existingReserva.getEvento().getAdministrador();
        administrador.getEventos().remove(existingReserva.getEvento());
        administradorRepository.save(administrador);

        reservasRepository.delete(existingReserva);

        return new ResponseEntity<>("Reserva eliminada con éxito", HttpStatus.OK);
    }
}