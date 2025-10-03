package fca.cafeteria.catalogoService;

import fca.cafeteria.catalogoRepository.BebidaRepository;
import fca.cafeteria.catalogoRepository.TipoBebidaRepository;
import fca.cafeteria.catalogoRequest.BebidaRequest;
import fca.cafeteria.clases.Bebida;
import fca.cafeteria.clases.TipoBebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    public Bebida registrarBebida(BebidaRequest bebidaRequest) {
        // 1. Buscar el TipoBebida por su ID
        TipoBebida tipoBebida = tipoBebidaRepository.findById(bebidaRequest.getIdtipobebida().intValue())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de bebida no encontrado"));

        // 2. Crear una nueva instancia de Bebida
        Bebida nuevaBebida = new Bebida();
        nuevaBebida.setNombre(bebidaRequest.getNombre());
        nuevaBebida.setDescripcion(bebidaRequest.getDescripcion());
        nuevaBebida.setTipoBebida(tipoBebida); // Asignar la instancia de TipoBebida

        // 3. Guardar la nueva bebida en la base de datos
        return bebidaRepository.save(nuevaBebida);
    }
}