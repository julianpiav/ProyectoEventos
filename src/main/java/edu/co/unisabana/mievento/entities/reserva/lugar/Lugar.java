package edu.co.unisabana.mievento.entities.reserva.lugar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Entity

@AllArgsConstructor
public abstract class Lugar {
    public Long getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Lugar getTipo() {
        return tipo;
    }
    public void setTipo(Lugar tipo) {
        this.tipo = tipo;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Id
    private Long idLugar;
    private String nombre;
    private String direccion;
    private int capacidad;
    private Lugar tipo; // Podría ser "Interior", "Exterior", "Virtual", etc.
    private boolean disponibilidad;
    private String descripcion;
}
