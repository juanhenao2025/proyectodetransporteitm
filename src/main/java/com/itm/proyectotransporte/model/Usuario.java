package com.itm.proyectotransporte.model;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String barrio;
    private String tipo;
}