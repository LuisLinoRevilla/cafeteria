package fca.cafeteria.clases;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tTipoBebida")
public class TipoBebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoBebida", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bebida> bebidas;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(Set<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
}