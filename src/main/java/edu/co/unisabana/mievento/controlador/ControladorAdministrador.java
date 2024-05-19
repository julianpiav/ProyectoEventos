package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.servicio.ServicioCliente;
import edu.co.unisabana.mievento.servicio.ServicioPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList; // Add this import statement

@RestController
@RequestMapping(path = "api/v1/administrador")
public class ControladorAdministrador {
    @Autowired
    private IClientRepository servicioCliente;
    @Autowired
    private ServicioPersonal servicioPersonal;
    
    @GetMapping(path = "/getUsers")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clienteList = new ArrayList<>(); // Fix the issue by importing ArrayList
        Iterable<Cliente> iterableClientes = servicioCliente.findAll();
        iterableClientes.forEach(clienteList::add);
        return new ResponseEntity<>(clienteList, HttpStatus.OK);
    }


    @GetMapping(path = "/personal/todos")
    public ResponseEntity<List<Personal>> obtenerPersonal() {
        List<Personal> personalList = servicioPersonal.obtenerPersonal();
        return new ResponseEntity<>(personalList, HttpStatus.OK);
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
