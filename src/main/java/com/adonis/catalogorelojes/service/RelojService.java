package com.adonis.catalogorelojes.service;

import com.adonis.catalogorelojes.model.Reloj;
import com.adonis.catalogorelojes.repository.RelojRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelojService {

    private final RelojRepository relojRepository;

    // Inyeccion de dependencias por constructor
    public RelojService(RelojRepository relojRepository) {
        this.relojRepository = relojRepository;
    }

    public List<Reloj> listarTodos() {
        return relojRepository.findAll();
    }

    public Reloj buscarPorId(Long id) {
        return relojRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reloj no encontrado con id: " + id));
    }

    public Reloj crear(Reloj reloj) {
        return relojRepository.save(reloj);
    }

    public Reloj actualizar(Long id, Reloj relojActualizado) {
        Reloj relojExistente = buscarPorId(id); // reutiliza el metodo de arriba

        relojExistente.setMarca(relojActualizado.getMarca());
        relojExistente.setModelo(relojActualizado.getModelo());
        relojExistente.setPrecio(relojActualizado.getPrecio());
        relojExistente.setStock(relojActualizado.getStock());

        return relojRepository.save(relojExistente);
    }

    public void eliminar(Long id) {
        if (!relojRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Reloj no encontrado con id: " + id);
        }
        relojRepository.deleteById(id);
    }
}