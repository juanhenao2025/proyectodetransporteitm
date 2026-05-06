package com.itm.proyectotransporte.dao;

import com.itm.proyectotransporte.interfaces.IUsuarioDAO;
import com.itm.proyectotransporte.model.Usuario;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class UsuarioJpaDAO implements IUsuarioDAO {

    private final UsuarioRepository usuarioRepository;

    public UsuarioJpaDAO(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public void insertar(Usuario u) {
        usuarioRepository.save(u);
    }

    @Override
    public void actualizar(Usuario u) {
        usuarioRepository.save(u);
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }
}