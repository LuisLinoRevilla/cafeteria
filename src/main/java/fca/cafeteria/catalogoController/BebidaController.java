package fca.cafeteria.catalogoController;

import fca.cafeteria.clases.Bebida;
import fca.cafeteria.catalogoService.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    public BebidaService bebidaService;

    @GetMapping("/tipo")
    public ResponseEntity<List<Bebida>> buscarBebidasPorTipo(@RequestParam String tipo) {
        List<Bebida> bebidas = bebidaService.buscarPorTipoBebida(tipo);
        return ResponseEntity.ok(bebidas);
    }

    // Método para agregar una bebida, si ya existía el código.
    @PostMapping
    public ResponseEntity<Bebida> agregarBebida(@RequestBody Bebida bebida,
                                                @RequestParam String tipoBebida) {
        Bebida nuevaBebida = bebidaService.agregarBebidaConTipo(bebida, tipoBebida);
        return ResponseEntity.ok(nuevaBebida);
    }
}