package ar.edu.utn.frbb.tup.retail.dto;

import java.util.ArrayList;
import java.util.Collections;

public class AltaCategoriaDto {
    private String nombre;
    private String descripcion;
    private ArrayList<String> tipos;

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

    public AltaCategoriaDto(String nombre) {
        this.nombre = nombre;
        tipos = new ArrayList<>();
        System.out.println("se creo AltaCategoriaDto con nombre "+nombre);
    }
    public AltaCategoriaDto(){
        tipos = new ArrayList<>();
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos.addAll(tipos);
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }
}
