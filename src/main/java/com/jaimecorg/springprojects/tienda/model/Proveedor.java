package com.jaimecorg.springprojects.tienda.model;

public class Proveedor {
    private int codigo;
    private String nombre;
    private String apellidos;
    private boolean puesto;

    public Proveedor() {
    }

    public Proveedor(int codigo) {
        this.codigo = codigo;
    }

    public Proveedor(int codigo, String nombre, String apellidos, boolean puesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.puesto = puesto;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isPuesto() {
        return puesto;
    }

    public void setPuesto(boolean puesto) {
        this.puesto = puesto;
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
        Proveedor other = (Proveedor) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}