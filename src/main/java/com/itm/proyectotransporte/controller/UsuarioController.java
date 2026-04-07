package com.itm.proyectotransporte.controller;

import com.itm.proyectotransporte.model.Usuario;
import com.itm.proyectotransporte.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones para gestionar usuarios del carpooling")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los usuarios")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por ID")
    public ResponseEntity<Usuario> buscar(@PathVariable int id) {
        Usuario u = usuarioService.buscarPorId(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public ResponseEntity<String> crear(@RequestBody Usuario u) {
        usuarioService.crear(u);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario existente")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody Usuario u) {
        u.setId(id);
        usuarioService.actualizar(u);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        usuarioService.eliminar(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
}