package com.itm.proyectotransporte.dao;

import com.itm.proyectotransporte.interfaces.IViajeDAO;
import com.itm.proyectotransporte.model.Viaje;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class ViajeJpaDAO implements IViajeDAO {

    private final ViajeRepository viajeRepository;

    public ViajeJpaDAO(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> listarTodos() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje buscarPorId(int id) {
        Optional<Viaje> viaje = viajeRepository.findById(id);
        return viaje.orElse(null);
    }

    @Override
    public void insertar(Viaje v) {
        viajeRepository.save(v);
    }

    @Override
    public void actualizar(Viaje v) {
        viajeRepository.save(v);
    }

    @Override
    public void eliminar(int id) {
        viajeRepository.deleteById(id);
    }
}