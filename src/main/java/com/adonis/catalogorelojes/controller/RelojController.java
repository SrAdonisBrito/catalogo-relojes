package com.adonis.catalogorelojes.controller;

import com.adonis.catalogorelojes.model.Reloj;
import com.adonis.catalogorelojes.service.RelojService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relojes")
public class RelojController {

    private final RelojService relojService;

    public RelojController(RelojService relojService) {
        this.relojService = relojService;
    }

    @GetMapping
    public List<Reloj> listarTodos() {
        return relojService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reloj> buscarPorId(@PathVariable Long id) {
        Reloj reloj = relojService.buscarPorId(id);
        return ResponseEntity.ok(reloj);
    }

    @PostMapping
    public ResponseEntity<Reloj> crear(@Valid @RequestBody Reloj reloj) {
        Reloj relojCreado = relojService.crear(reloj);
        return ResponseEntity.status(HttpStatus.CREATED).body(relojCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reloj> actualizar(@PathVariable Long id, @Valid @RequestBody Reloj reloj) {
        Reloj relojActualizado = relojService.actualizar(id, reloj);
        return ResponseEntity.ok(relojActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        relojService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}