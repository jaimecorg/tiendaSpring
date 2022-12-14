package com.jaimecorg.springprojects.tienda.model;

import java.util.Date;

public class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String urlImg;
    private Date fecha;

    public Producto() {
    }

    public Producto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto(int codigo, String nombre, String descripcion, String urlImg, Date fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

}
