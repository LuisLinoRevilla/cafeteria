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

    // This method handles the logic for adding a beverage and its type.
    public Bebida agregarBebidaConTipo(Bebida bebida, String descripcionTipoBebida) {
        Optional<TipoBebida> tipoExistente = tipoBebidaRepository.findByDescripcion(descripcionTipoBebida);

        TipoBebida tipoBebida;

        if (tipoExistente.isPresent()) {
            tipoBebida = tipoExistente.get();
        } else {
            tipoBebida = new TipoBebida();
            tipoBebida.setDescripcion(descripcionTipoBebida);
            tipoBebidaRepository.save(tipoBebida);
        }

        bebida.settipoBebida(tipoBebida);
        return bebidaRepository.save(bebida);
    }

    // This is the correct method for searching beverages by type.
    public List<Bebida> buscarPorTipoBebida(String descripcionTipoBebida) {
        String tipoLimpio = descripcionTipoBebida.trim();
        if (tipoLimpio.isEmpty()) {
            return Collections.emptyList();
        }
        return bebidaRepository.findByTipoBebida_DescripcionIgnoreCase(tipoLimpio);
    }
}