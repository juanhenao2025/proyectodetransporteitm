package com.itm.proyectotransporte.service;

import com.itm.proyectotransporte.dao.ViajeDAO;
import com.itm.proyectotransporte.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    private final ViajeDAO viajeDAO;

    public ViajeService(ViajeDAO viajeDAO) {
        this.viajeDAO = viajeDAO;
    }

    public List<Viaje> listarTodos() {
        return viajeDAO.listarTodos();
    }

    public Viaje buscarPorId(int id) {
        return viajeDAO.buscarPorId(id);
    }

    public void crear(Viaje v) {
        viajeDAO.insertar(v);
    }

    public void actualizar(Viaje v) {
        viajeDAO.actualizar(v);
    }

    public void eliminar(int id) {
        viajeDAO.eliminar(id);
    }
}