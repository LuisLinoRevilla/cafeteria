package fca.cafeteria.catalogoRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import fca.cafeteria.clases.Bebida;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer>, JpaSpecificationExecutor<Bebida> {

    List<Bebida> findByTipoBebida_DescripcionContainingIgnoreCase(String descripcion);
}