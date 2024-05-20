package edu.co.unisabana.mievento.controlador;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.usuario.Cliente;
import edu.co.unisabana.mievento.repository.IClientRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList; // Add this import statement

@RestController
@RequestMapping(path = "api/v1/administrador")
public class ControladorAdministrador {
    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private IPersonalRepository personalRepository;

    @GetMapping(path = "/getUsers")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clienteList = new ArrayList<>();
        Iterable<Cliente> iterableClientes = clientRepository.findAll();
        iterableClientes.forEach(clienteList::add);
        return new ResponseEntity<>(clienteList, HttpStatus.OK);
    }

    //Ya funciona
    @GetMapping(path = "/getPersonal")
    public ResponseEntity<List<Personal>> obtenerPersonal() {
        List<Personal> personalList = new ArrayList<>();
        Iterable<Personal> iterablePersonal = personalRepository.findAll();
        iterablePersonal.forEach(personalList::add);
        return new ResponseEntity<>(personalList, HttpStatus.OK);
    }

    //Ya funciona pero falta en el front
    @GetMapping(path = "/personal/{id}")
    public ResponseEntity<Personal> obtenerPersonalPorId(@PathVariable("id") int id) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        return optionalPersonal.map(personal -> new ResponseEntity<>(personal, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //Funciona
    @PutMapping(path = "/personal/modificar/{id}")
    public ResponseEntity<Personal> modificarPersonal(@PathVariable("id") int id, @RequestBody Personal personal) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        if (optionalPersonal.isPresent()) {
            Personal personalExistente = optionalPersonal.get();
            personalExistente.setApellido(personal.getApellido());
            personalExistente.setContacto(personal.getContacto());
            personalExistente.setDisponible(personal.isDisponible());
            personalExistente.setIdPersonal(personal.getIdPersonal());
            personalExistente.setNombre(personal.getNombre());
            personalRepository.save(personalExistente);

            return new ResponseEntity<>(personalExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/personal/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable("id") Long id) {
        //servicioPersonal.eliminarPersonal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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

    //funciona
    @PostMapping(path = "/personal/guardar")
    public ResponseEntity<Boolean> guardarPersonal(@RequestBody Personal personal) {
        personalRepository.save(personal);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
