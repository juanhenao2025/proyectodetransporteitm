package com.itm.proyectotransporte.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "cupos")
    private int cupos;

    @Column(name = "conductor_id")
    private int conductorId;
}