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

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Set<BebidaIngrediente> getBebidas() {
        return bebidas;
    }

    public void setBebidas(Set<BebidaIngrediente> bebidas) {
        this.bebidas = bebidas;
    }
}