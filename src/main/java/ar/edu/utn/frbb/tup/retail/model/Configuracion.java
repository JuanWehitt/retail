package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Configuracion extends HashMap<String,String> {
    private String nombre;

    public Configuracion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
