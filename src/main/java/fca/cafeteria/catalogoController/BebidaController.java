package fca.cafeteria.catalogoController;

import fca.cafeteria.catalogoRequest.BebidaRequest;
import fca.cafeteria.catalogoService.BebidaService;
import fca.cafeteria.clases.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @PostMapping
    public ResponseEntity<Bebida> crearBebida(@RequestBody BebidaRequest bebidaRequest) {
        try {
            Bebida bebidaCreada = bebidaService.registrarBebida(bebidaRequest);
            return new ResponseEntity<>(bebidaCreada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}