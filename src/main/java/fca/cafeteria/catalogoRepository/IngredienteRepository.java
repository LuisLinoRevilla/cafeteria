package fca.cafeteria.catalogoRepository;

import fca.cafeteria.clases.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    @Query("SELECT i FROM Ingrediente i WHERE LOWER(i.nombre) LIKE %:nombre%")
    List<Ingrediente> findByNombre(@Param("nombre") String nombre);
}