package fca.cafeteria.catalogoService;

import fca.cafeteria.clases.Ingrediente;
import fca.cafeteria.catalogoRepository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> buscarIngredientesPorNombre(String nombre, Float costo) {
        String nombreLimpio = nombre != null ? nombre.trim().toLowerCase() : "";
        if (nombreLimpio.isEmpty()) {
            return ingredienteRepository.findAll(); // Devuelve todos si el filtro está vacío
        }
        return ingredienteRepository.findByNombre(nombreLimpio);
    }
}