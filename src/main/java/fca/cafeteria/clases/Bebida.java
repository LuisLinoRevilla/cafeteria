package fca.cafeteria.clases;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbebida")
@Data
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipobebida")
    private TipoBebida tipoBebida;
}