package com.itm.proyectotransporte.controller;

import com.itm.proyectotransporte.model.Viaje;
import com.itm.proyectotransporte.service.ViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
@Tag(name = "Viajes", description = "Gestión de viajes compartidos entre estudiantes del ITM")
public class ViajeController {

    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los viajes")
    public ResponseEntity<List<Viaje>> listar() {
        return ResponseEntity.ok(viajeService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar viaje por ID")
    public ResponseEntity<Viaje> buscar(@PathVariable int id) {
        Viaje v = viajeService.buscarPorId(id);
        if (v == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(v);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo viaje")
    public ResponseEntity<String> crear(@RequestBody Viaje v) {
        viajeService.crear(v);
        return ResponseEntity.ok("Viaje creado exitosamente");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un viaje existente")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody Viaje v) {
        v.setId(id);
        viajeService.actualizar(v);
        return ResponseEntity.ok("Viaje actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un viaje")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        viajeService.eliminar(id);
        return ResponseEntity.ok("Viaje eliminado exitosamente");
    }
}