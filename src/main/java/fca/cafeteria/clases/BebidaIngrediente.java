package fca.cafeteria.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "tBebidaIngrediente")
public class BebidaIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBebida", nullable = false)
    private Bebida bebida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idIngrediente", nullable = false)
    private Ingrediente ingrediente;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

}