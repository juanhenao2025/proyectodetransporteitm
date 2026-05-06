package com.itm.proyectotransporte.interfaces;

import com.itm.proyectotransporte.model.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> listarTodos();
    Usuario buscarPorId(int id);
    void insertar(Usuario u);
    void actualizar(Usuario u);
    void eliminar(int id);
}
