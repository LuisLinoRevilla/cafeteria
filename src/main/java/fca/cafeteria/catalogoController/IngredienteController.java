package fca.cafeteria.catalogoController;

import fca.cafeteria.clases.Ingrediente;
import fca.cafeteria.catalogoService.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingrediente") // Nota: la ruta es '/ingrediente'
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Ingrediente>> buscarIngredientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Float costoMin,
            @RequestParam(required = false) Float costoMax) {

        List<Ingrediente> ingredientes = ingredienteService.buscarIngredientesConFiltros(nombre, costoMin, costoMax);
        return ResponseEntity.ok(ingredientes);
    }
}