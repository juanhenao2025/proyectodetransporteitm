package com.itm.proyectotransporte.service;

import com.itm.proyectotransporte.interfaces.IViajeDAO;
import com.itm.proyectotransporte.interfaces.IViajeService;
import com.itm.proyectotransporte.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService implements IViajeService {

    private final IViajeDAO viajeDAO;

    public ViajeService(IViajeDAO viajeDAO) {
        this.viajeDAO = viajeDAO;
    }

    @Override
    public List<Viaje> listarTodos() {
        return viajeDAO.listarTodos();
    }

    @Override
    public Viaje buscarPorId(int id) {
        return viajeDAO.buscarPorId(id);
    }

    @Override
    public void crear(Viaje v) {
        viajeDAO.insertar(v);
    }

    @Override
    public void actualizar(Viaje v) {
        viajeDAO.actualizar(v);
    }

    @Override
    public void eliminar(int id) {
        viajeDAO.eliminar(id);
    }
}