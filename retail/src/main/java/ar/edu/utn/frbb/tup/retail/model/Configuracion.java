package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.List;

public class Configuracion {
    private String nombre;
    private List<String> listaDeOpciones;
    private String opcionElegida;

    public Configuracion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public List<String> getListaDeOpciones() {
        return listaDeOpciones;
    }

    public void agregarOpcion(String op){
        if(listaDeOpciones!=null){
            listaDeOpciones.add(op);
        }else{
            listaDeOpciones = new ArrayList<>();
            listaDeOpciones.add(op);
        }
    }

    public void eliminarOpcion(String op){
        if(listaDeOpciones!=null){
            listaDeOpciones.remove(op);
        }
    }


}
