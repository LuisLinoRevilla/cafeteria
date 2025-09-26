package fca.cafeteria.catalogoService;

import fca.cafeteria.clases.Bebida;
import fca.cafeteria.clases.TipoBebida;
import fca.cafeteria.catalogoRepository.BebidaRepository;
import fca.cafeteria.catalogoRepository.TipoBebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    public BebidaRepository bebidaRepository;

    @Autowired
    public TipoBebidaRepository tipoBebidaRepository;

    // Método para agregar una bebida, verificando o creando su tipo.
    public Bebida agregarBebidaConTipo(Bebida bebida, String descripcionTipoBebida) {

        // 1. Buscar si el TipoBebida ya existe.
        Optional<TipoBebida> tipoExistente = tipoBebidaRepository.findByDescripcion(descripcionTipoBebida);

        TipoBebida tipoBebida;

        if (tipoExistente.isPresent()) {
            // 2. Si existe, usar el TipoBebida encontrado.
            tipoBebida = tipoExistente.get();
        } else {
            // 3. Si no existe, crear un nuevo TipoBebida y guardarlo.
            tipoBebida = new TipoBebida();
            tipoBebida.setDescripcion(descripcionTipoBebida);
            tipoBebidaRepository.save(tipoBebida);
        }

        // 4. Asignar el TipoBebida (nuevo o existente) a la Bebida.
        bebida.settipoBebida(tipoBebida);

        // 5. Guardar la Bebida en el repositorio.
        return bebidaRepository.save(bebida);
    }


    // Método para buscar bebidas por tipo.
    public List<Bebida> buscarPorTipoBebida(String descripcionTipoBebida) {
        String tipoLimpio = descripcionTipoBebida.trim();
        if (tipoLimpio.isEmpty()) {
            return Collections.emptyList();
        }
        return bebidaRepository.findByTipoBebida_DescripcionContainingIgnoreCase(tipoLimpio);
    }


    // Método para obtener todas las bebidas.
    public List<Bebida> findAll() {
        return bebidaRepository.findAll();
    }
}