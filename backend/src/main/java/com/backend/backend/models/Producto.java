package com.backend.backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="codigo")
    private String codigo;
    @Column(name="vencimiento")
    private Date vencimiento;
    @Column(name="categoria")
    private String categoria;
    @Column(name="precio")
    private Integer precio;

    public Producto() {
    }

    public Producto(String codigo, String nombre, Date vencimiento, String categoria, Integer precio) {
        this.nombre = nombre;
        this.codigo  = codigo;
        this.vencimiento = vencimiento;
        this.categoria = categoria;
        this.precio = precio;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
