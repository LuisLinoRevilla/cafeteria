package fca.cafeteria.catalogoRepository;

import fca.cafeteria.clases.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBebidaRepository extends JpaRepository<TipoBebida, Integer> {
}