package edu.co.unisabana.mievento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import edu.co.unisabana.mievento.factory.FabricaEventos;
import edu.co.unisabana.mievento.repository.IReservasRepository;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControladorClienteTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FabricaEventos fabricaEventos;

    @MockBean
    private IReservasRepository reservasRepository;

    @Test
    void obtenerReserva() throws Exception {
        mockMvc.perform(get("/api/v1/cliente/reservas/todos"))
                .andExpect(status().isOk());
    }

    @Test
    void obtenerReservaPorId() throws Exception {
        mockMvc.perform(get("/api/v1/cliente/reserva/1"))
                .andExpect(status().isOk());
    }

   /* @Test
    void guardarReserva() throws Exception {
        String reservaJson = "{\"evento\":{\"nombre\":\"Evento de prueba\",\"fecha\":\"2022-12-31\",\"lugar\":\"Bogotá\"}}";
        mockMvc.perform(post("/api/v1/cliente/reserva/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reservaJson))
                .andExpect(status().isCreated());
    }

    @Test
    void modificarReserva() throws Exception {
        String reservaJson = "{\"id\":1,\"evento\":{\"nombre\":\"Evento modificado\",\"fecha\":\"2022-12-31\",\"lugar\":\"Bogotá\"}}";
        mockMvc.perform(put("/api/v1/cliente/reserva/modificar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reservaJson))
                .andExpect(status().isOk());
    }*/ 

    @Test
    void eliminarReserva() throws Exception {
        mockMvc.perform(delete("/api/v1/cliente/reserva/delete/1"))
                .andExpect(status().isNoContent());
    }
}
