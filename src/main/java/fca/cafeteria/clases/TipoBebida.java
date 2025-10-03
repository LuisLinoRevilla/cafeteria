package fca.cafeteria.clases;

// Asegúrate de tener esta importación
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "ttipobebida")
@Data
public class TipoBebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoBebida", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bebida> bebidas;
}