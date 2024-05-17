package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entidades.personal.Personal;
import edu.co.unisabana.mievento.entidades.reserva.Reserva;
import edu.co.unisabana.mievento.servicio.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ControladorCliente {

    @Autowired
    private ServicioReserva servicioReserva;

    @GetMapping(path = "/reservas/todos")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        return new ResponseEntity<>(servicioReserva.obtenerReservas(), HttpStatus.OK);
    }
    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable("id") Long id) {
        return new ResponseEntity<>(servicioReserva.obtenerReservaPorId(id),HttpStatus.OK);
    }

    @PostMapping(path = "/reserva/guardar")
    public ResponseEntity<String> guardarReserva(@RequestBody Reserva reserva) {
        servicioReserva.guardarOEditarReserva(reserva);
        return new ResponseEntity<>("Reserva guardada con Exito", HttpStatus.CREATED);
    }
    @PutMapping(path = "/reserva/modificar")
    public ResponseEntity<String> modificarReserva(@RequestBody Reserva reserva) {
        servicioReserva.guardarOEditarReserva(reserva);
        return new ResponseEntity<>("Reserva modificada con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/personal/delete/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable("id") Long id) {
        servicioReserva.eliminarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
