package edu.co.unisabana.mievento;

import org.junit.jupiter.api.Test;

import edu.co.unisabana.mievento.entities.personal.Personal;
import edu.co.unisabana.mievento.entities.usuario.Administrador;
import edu.co.unisabana.mievento.repository.IAdministradorRepository;
import edu.co.unisabana.mievento.repository.IPersonalRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MiClaseDePruebas {

    @Test
    void agregarPersonal() {
        // Crea un mock de tu repositorio
        IPersonalRepository repositorio = mock(IPersonalRepository.class);

        // Define el comportamiento del mock
        when(repositorio.save(any(Personal.class))).thenReturn(new Personal());

        // Llama al método que quieres probar
        Personal personal = new Personal();
        Personal resultado = repositorio.save(personal);

        // Verifica el resultado
        assertNotNull(resultado);

        // Verifica que el método del mock fue llamado
        verify(repositorio, times(1)).save(any(Personal.class));
    }

    @Test
    void agregarAdministrador() {
        // Crea un mock de tu repositorio
        IAdministradorRepository repositorio = mock(IAdministradorRepository.class);

        // Define el comportamiento del mock
        when(repositorio.save(any(Administrador.class))).thenReturn(new Administrador());

        // Llama al método que quieres probar
        Administrador administrador = new Administrador();
        Administrador resultado = repositorio.save(administrador);

        // Verifica el resultado
        assertNotNull(resultado);

        // Verifica que el método del mock fue llamado
        verify(repositorio, times(1)).save(any(Administrador.class));
    }
}
