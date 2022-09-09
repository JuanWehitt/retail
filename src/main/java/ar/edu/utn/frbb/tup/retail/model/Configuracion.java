package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.List;

public class Configuracion {
    private String tipo;
    private String nombre;
    private List<String> listaDeOpciones;
    private String opcionElegida;



    public Configuracion(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
