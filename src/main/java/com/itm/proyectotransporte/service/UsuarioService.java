package com.itm.proyectotransporte.service;

import com.itm.proyectotransporte.dao.UsuarioDAO;
import com.itm.proyectotransporte.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public void crear(Usuario u) {
        usuarioDAO.insertar(u);
    }

    public void actualizar(Usuario u) {
        usuarioDAO.actualizar(u);
    }

    public void eliminar(int id) {
        usuarioDAO.eliminar(id);
    }
}