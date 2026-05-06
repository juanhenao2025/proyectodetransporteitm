package com.itm.proyectotransporte;

import com.itm.proyectotransporte.interfaces.IUsuarioDAO;
import com.itm.proyectotransporte.model.Usuario;
import com.itm.proyectotransporte.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private IUsuarioDAO usuarioDAO;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {
        Usuario u1 = new Usuario();
        u1.setId(1);
        u1.setNombre("Juan Henao");
        u1.setCorreo("juan@itm.edu.co");
        u1.setTipo("CONDUCTOR");

        Usuario u2 = new Usuario();
        u2.setId(2);
        u2.setNombre("Maria Lopez");
        u2.setCorreo("maria@itm.edu.co");
        u2.setTipo("PASAJERO");

        when(usuarioDAO.listarTodos()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> resultado = usuarioService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals("Juan Henao", resultado.get(0).getNombre());
        verify(usuarioDAO, times(1)).listarTodos();
    }

    @Test
    void testBuscarPorId() {
        Usuario u = new Usuario();
        u.setId(1);
        u.setNombre("Juan Henao");
        u.setCorreo("juan@itm.edu.co");
        u.setTipo("CONDUCTOR");

        when(usuarioDAO.buscarPorId(1)).thenReturn(u);

        Usuario resultado = usuarioService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals("Juan Henao", resultado.getNombre());
        verify(usuarioDAO, times(1)).buscarPorId(1);
    }

    @Test
    void testCrearUsuario() {
        Usuario u = new Usuario();
        u.setNombre("Carlos Perez");
        u.setCorreo("carlos@itm.edu.co");
        u.setTipo("PASAJERO");

        usuarioService.crear(u);

        verify(usuarioDAO, times(1)).insertar(u);
    }

    @Test
    void testEliminarUsuario() {
        usuarioService.eliminar(1);
        verify(usuarioDAO, times(1)).eliminar(1);
    }

    @Test
    void testActualizarUsuario() {
        Usuario u = new Usuario();
        u.setId(1);
        u.setNombre("Juan Actualizado");
        u.setCorreo("juan@itm.edu.co");
        u.setTipo("CONDUCTOR");

        usuarioService.actualizar(u);

        verify(usuarioDAO, times(1)).actualizar(u);
    }
}