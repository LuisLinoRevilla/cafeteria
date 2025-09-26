package fca.cafeteria.catalogoRepository;

import fca.cafeteria.clases.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoBebidaRepository extends JpaRepository<TipoBebida, Integer> {

    // Método para buscar un tipo de bebida por su descripción
    Optional<TipoBebida> findByDescripcion(String descripcion);
}