package fca.cafeteria.clases;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tBebida")
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoBebida", referencedColumnName = "id")
    private TipoBebida tipoBebida;

    @OneToMany(mappedBy = "bebida", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BebidaIngrediente> ingredientes;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Set<BebidaIngrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<BebidaIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}