package com.itm.proyectotransporte;

import com.itm.proyectotransporte.interfaces.IViajeDAO;
import com.itm.proyectotransporte.model.Viaje;
import com.itm.proyectotransporte.service.ViajeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViajeServiceTest {

    @Mock
    private IViajeDAO viajeDAO;

    @InjectMocks
    private ViajeService viajeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {
        Viaje v1 = new Viaje();
        v1.setId(1);
        v1.setOrigen("Laureles");
        v1.setDestino("ITM Fraternidad");
        v1.setCupos(3);

        Viaje v2 = new Viaje();
        v2.setId(2);
        v2.setOrigen("Poblado");
        v2.setDestino("ITM Fraternidad");
        v2.setCupos(2);

        when(viajeDAO.listarTodos()).thenReturn(Arrays.asList(v1, v2));

        List<Viaje> resultado = viajeService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals("Laureles", resultado.get(0).getOrigen());
        verify(viajeDAO, times(1)).listarTodos();
    }

    @Test
    void testBuscarPorId() {
        Viaje v = new Viaje();
        v.setId(1);
        v.setOrigen("Laureles");
        v.setDestino("ITM Fraternidad");
        v.setCupos(3);

        when(viajeDAO.buscarPorId(1)).thenReturn(v);

        Viaje resultado = viajeService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals("Laureles", resultado.getOrigen());
        verify(viajeDAO, times(1)).buscarPorId(1);
    }

    @Test
    void testCrearViaje() {
        Viaje v = new Viaje();
        v.setOrigen("Bello");
        v.setDestino("ITM Fraternidad");
        v.setCupos(4);

        viajeService.crear(v);

        verify(viajeDAO, times(1)).insertar(v);
    }

    @Test
    void testEliminarViaje() {
        viajeService.eliminar(1);
        verify(viajeDAO, times(1)).eliminar(1);
    }

    @Test
    void testActualizarViaje() {
        Viaje v = new Viaje();
        v.setId(1);
        v.setOrigen("Laureles Actualizado");
        v.setDestino("ITM Fraternidad");
        v.setCupos(2);

        viajeService.actualizar(v);

        verify(viajeDAO, times(1)).actualizar(v);
    }
}