package fca.cafeteria.catalogoService;

import fca.cafeteria.clases.Ingrediente;
import fca.cafeteria.catalogoRepository.IngredienteRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> buscarIngredientesConFiltros(String nombre, Float costoMin, Float costoMax) {
        return ingredienteRepository.findAll(buildSpecification(nombre, costoMin, costoMax));
    }

    private Specification<Ingrediente> buildSpecification(String nombre, Float costoMin, Float costoMax) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nombre != null && !nombre.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.trim().toLowerCase() + "%"));
            }

            if (costoMin != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("costo"), costoMin));
            }

            if (costoMax != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("costo"), costoMax));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}