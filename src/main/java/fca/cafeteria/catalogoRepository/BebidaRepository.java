package fca.cafeteria.catalogoRepository;

import fca.cafeteria.clases.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {
}