package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pale")
public class Pale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPale;
    private String codigo;
    private Float capacidad;
    @ManyToOne
    @JoinColumn(name = "id_camara", nullable = false)
    private Camara camara;

    public Integer getIdPale() {
        return idPale;
    }

    public void setIdPale(Integer idPale) {
        this.idPale = idPale;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }
}
