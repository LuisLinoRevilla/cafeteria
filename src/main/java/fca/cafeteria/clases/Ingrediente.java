package fca.cafeteria.clases;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tIngrediente")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Float costo;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BebidaIngrediente> bebidas;

}