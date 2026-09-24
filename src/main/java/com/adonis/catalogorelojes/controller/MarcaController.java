package com.adonis.catalogorelojes.controller;

import com.adonis.catalogorelojes.model.Marca;
import com.adonis.catalogorelojes.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> listarTodos() {
        return marcaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Marca> crear(@Valid @RequestBody Marca marca) {
        Marca marcaCreada = marcaService.crear(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaCreada);
    }
}
