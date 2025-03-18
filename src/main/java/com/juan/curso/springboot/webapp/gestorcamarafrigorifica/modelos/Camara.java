package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "camara")
public class Camara {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCamara;
    @NotEmpty
    private String nombre;
    @NotNull
    private Double temperatura;
    @NotNull
    private Double capacidad;
    @NotEmpty
    private String ubicacion;

    public Integer getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
