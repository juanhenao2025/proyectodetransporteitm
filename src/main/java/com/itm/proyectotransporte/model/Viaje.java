package com.itm.proyectotransporte.model;

import lombok.Data;

@Data
public class Viaje {
    private int id;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private int cupos;
    private int conductorId;
}