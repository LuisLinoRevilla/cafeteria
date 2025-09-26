package fca.cafeteria.catalogoRepository;

import fca.cafeteria.clases.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer>, JpaSpecificationExecutor<Bebida> {

    // Método de búsqueda por descripción del tipo de bebida, insensible a mayúsculas y minuscules.
    List<Bebida> findByTipoBebida_DescripcionIgnoreCase(String descripcion);
}