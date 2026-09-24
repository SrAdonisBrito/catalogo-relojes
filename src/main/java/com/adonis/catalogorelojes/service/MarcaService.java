package com.adonis.catalogorelojes.service;

import com.adonis.catalogorelojes.model.Marca;
import com.adonis.catalogorelojes.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    //Inyeccion de dependecia por constructor
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }

    public Marca crear(Marca marca) {
        return marcaRepository.save(marca);
    }

}
