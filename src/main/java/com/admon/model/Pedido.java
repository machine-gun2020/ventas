package com.admon.model;

import jakarta.persistence.*;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;
import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonbProperty("id")
    private Long id;
    //@JsonbProperty("cliente")
    private String cliente;
    //@JsonbProperty("total")
    private Double total;
    //@JsonbProperty("estado")
    private String estado;
    //@JsonbProperty("fecha")
    private LocalDate fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
// Getters y Setters

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
