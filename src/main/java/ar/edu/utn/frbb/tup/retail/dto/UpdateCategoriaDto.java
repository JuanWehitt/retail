package ar.edu.utn.frbb.tup.retail.dto;

import java.util.ArrayList;

public class UpdateCategoriaDto {

    private String nombre;
    private String descripcion;
    private ArrayList<String> tipos;

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
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
}
