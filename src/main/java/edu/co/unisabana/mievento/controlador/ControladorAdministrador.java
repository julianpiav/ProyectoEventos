package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entidades.usuario.Cliente;
import edu.co.unisabana.mievento.entidades.personal.Personal;
import edu.co.unisabana.mievento.servicio.ServicioCliente;
import edu.co.unisabana.mievento.servicio.ServicioPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/administrador")
public class ControladorAdministrador {
    @Autowired
    private ServicioCliente servicioCliente;
    @Autowired
    private ServicioPersonal servicioPersonal;

    @GetMapping(path = "/clientes/todos")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        return new ResponseEntity<>(servicioCliente.obtenerClientes(), HttpStatus.OK);
    }

    @GetMapping(path = "/personal/todos")
    public ResponseEntity<List<Personal>> obtenerPersonal() {
        return new ResponseEntity<>(servicioPersonal.obtenerPersonal(), HttpStatus.OK);
    }
    @GetMapping(path = "/personal/{id}")
    public ResponseEntity<Personal> obtenerPersonalPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(servicioPersonal.obtenerPersonalPorId(id),HttpStatus.OK);
    }

    @PostMapping(path = "/personal/guardar")
    public ResponseEntity<String> guardarPersonal(@RequestBody Personal personal) {
        servicioPersonal.guardarOEditarPersonal(personal);
        return new ResponseEntity<>("Personal guardado con Exito", HttpStatus.CREATED);
    }
    @PutMapping(path = "/personal/modificar")
    public ResponseEntity<String> modificarPersonal(@RequestBody Personal personal) {
        servicioPersonal.guardarOEditarPersonal(personal);
        return new ResponseEntity<>("Personal modificado con éxito", HttpStatus.OK);
    }


    @DeleteMapping("/personal/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable("id") Long id) {
        servicioPersonal.eliminarPersonal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
