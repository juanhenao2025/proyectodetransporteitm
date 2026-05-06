package com.itm.proyectotransporte.interfaces;

import com.itm.proyectotransporte.model.Viaje;
import java.util.List;

public interface IViajeService {
    List<Viaje> listarTodos();
    Viaje buscarPorId(int id);
    void crear(Viaje v);
    void actualizar(Viaje v);
    void eliminar(int id);
}