package com.itm.proyectotransporte.interfaces;

import com.itm.proyectotransporte.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarTodos();
    Usuario buscarPorId(int id);
    void crear(Usuario u);
    void actualizar(Usuario u);
    void eliminar(int id);
}