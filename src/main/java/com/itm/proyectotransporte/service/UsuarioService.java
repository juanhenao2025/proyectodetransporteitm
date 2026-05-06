package com.itm.proyectotransporte.service;

import com.itm.proyectotransporte.interfaces.IUsuarioDAO;
import com.itm.proyectotransporte.interfaces.IUsuarioService;
import com.itm.proyectotransporte.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioDAO usuarioDAO;

    public UsuarioService(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    @Override
    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    @Override
    public void crear(Usuario u) {
        usuarioDAO.insertar(u);
    }

    @Override
    public void actualizar(Usuario u) {
        usuarioDAO.actualizar(u);
    }

    @Override
    public void eliminar(int id) {
        usuarioDAO.eliminar(id);
    }
}