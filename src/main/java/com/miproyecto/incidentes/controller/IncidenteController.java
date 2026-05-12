package com.miproyecto.incidentes.controller;

import java.util.List;
import com.miproyecto.incidentes.model.Incidente;
import com.miproyecto.incidentes.repository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IncidenteRepository repository;

    // CREAR INCIDENTE
    @PostMapping
public Incidente crearIncidente(@RequestBody Incidente incidente) {

    // VALIDACIÓN
    if (incidente.getDescripcion() == null || incidente.getDescripcion().isEmpty()) {
        throw new RuntimeException("La descripción es obligatoria");
    }

    // lógica normal
    incidente.setEstado("Pendiente");
    return repository.save(incidente);
}

    // LISTAR INCIDENTES
    @GetMapping
    public List<Incidente> listarIncidentes() {
        return repository.findAll();
    }
    
    @GetMapping("/oficina/{oficina}")
public List<Incidente> obtenerPorOficina(@PathVariable String oficina) {
    return repository.findByOficina(oficina);
}

    @GetMapping("/historial/{id}")
public List<Incidente> obtenerHistorial(@PathVariable Long id) {
    return repository.findAll()
            .stream()
            .filter(i -> id.equals(i.getIncidentePadreId()))
            .toList();

}
    @GetMapping("/{id}")
public Incidente obtenerPorId(@PathVariable Long id) {
    return repository.findById(id).orElse(null);
}
}