package ar.edu.utn.frbb.tup.retail.dto;

import java.util.ArrayList;
import java.util.List;

public class UpdateEspecificacionProductoDto {

    private String nombre;
    private List<String> opciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public UpdateEspecificacionProductoDto(String nombre, ArrayList<String> opciones) {
        this.opciones = new ArrayList<String>();
        this.nombre = nombre;
        this.opciones = opciones;
    }

}
