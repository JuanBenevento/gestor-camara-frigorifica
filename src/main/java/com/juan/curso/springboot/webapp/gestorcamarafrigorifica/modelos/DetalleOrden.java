package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenCarga ordenCarga;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    private Integer cantidad;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalleOrden(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public OrdenCarga getOrdenCarga() {
        return ordenCarga;
    }

    public void setOrdenCarga(OrdenCarga ordenCarga) {
        this.ordenCarga = ordenCarga;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
