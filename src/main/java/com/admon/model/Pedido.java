package com.admon.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private Double total;
    private String estado;
    private LocalDate fecha;

    // Getters y Setters
}
