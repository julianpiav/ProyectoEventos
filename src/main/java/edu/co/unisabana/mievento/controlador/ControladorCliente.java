package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.reserva.Reserva;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;
import edu.co.unisabana.mievento.servicio.ServicioPersonal;
import edu.co.unisabana.mievento.servicio.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ControladorCliente {

    @Autowired
    private ServicioReserva servicioReserva;

    @Autowired
    private ServicioPersonal servicioPersonal;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IPersonalRepository PersonalRepository;

    // Endpoints para reservas
    @GetMapping(path = "/reservas/todos")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        List<Reserva> reservas = servicioReserva.obtenerReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable("id") Long id) {
        Reserva reserva = servicioReserva.obtenerReservaPorId(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping(path = "/reserva/guardar")
    public ResponseEntity<String> guardarReserva(@RequestBody Reserva reserva) {
        servicioReserva.guardarOEditarReserva(reserva);
        return new ResponseEntity<>("Reserva guardada con éxito", HttpStatus.CREATED);
    }

    @PutMapping(path = "/reserva/modificar")
    public ResponseEntity<String> modificarReserva(@RequestBody Reserva reserva) {
        servicioReserva.guardarOEditarReserva(reserva);
        return new ResponseEntity<>("Reserva modificada con éxito", HttpStatus.OK);
    }

    @DeleteMapping(path = "/reserva/delete/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable("id") Long id) {
        servicioReserva.eliminarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoints para usuarios
    @PostMapping(path = "/usuario/registro")
    public ResponseEntity<Boolean> addClient(@RequestBody Cliente cliente) {
        clientRepository.save(cliente);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(path = "/usuarios/todos")
    public ResponseEntity<List<Cliente>> obtenerTodosLosUsuarios() {
        Iterable<Cliente> usuariosIterable = clientRepository.findAll();
        List<Cliente> usuarios = new ArrayList<>();
        usuariosIterable.forEach(usuarios::add);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<Cliente> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        Cliente usuario = clientRepository.findById(id).orElse(null);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping(path = "/usuario/modificar")
    public ResponseEntity<String> modificarUsuario(@RequestBody Cliente cliente) {
        clientRepository.save(cliente);
        return new ResponseEntity<>("Usuario modificado con éxito", HttpStatus.OK);
    }

    @DeleteMapping(path = "/usuario/delete/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Integer id) {
        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // Endpoints para personal
    @GetMapping(path = "/personal/todos")
    public ResponseEntity<List<Personal>> obtenerTodoElPersonal() {
        List<Personal> personal = servicioPersonal.obtenerPersonal();
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @GetMapping(path = "/personal/{id}")
    public ResponseEntity<Personal> obtenerPersonalPorId(@PathVariable("id") Long id) {
        Personal personal = servicioPersonal.obtenerPersonalPorId(id);
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    //funciona
    @PostMapping(path = "/personal/guardar")
    public ResponseEntity<Boolean> guardarPersonal(@RequestBody Personal personal) {
        PersonalRepository.save(personal);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    

    @PutMapping(path = "/personal/modificar")
    public ResponseEntity<String> modificarPersonal(@RequestBody Personal personal) {
        servicioPersonal.guardarOEditarPersonal(personal);
        return new ResponseEntity<>("Personal modificado con éxito", HttpStatus.OK);
    }

    @DeleteMapping(path = "/personal/delete/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable("id") Long id) {
        servicioPersonal.eliminarPersonal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}