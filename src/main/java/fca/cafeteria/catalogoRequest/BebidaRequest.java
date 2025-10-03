package fca.cafeteria.catalogoRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Para asegurar que el deserializador de JSON funcione
public class BebidaRequest {

    private String nombre;
    private String descripcion;
    private Long idtipobebida;
}