package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Categoria {
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> productos;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria() {
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

    public void agregarProducto(Producto p){
        if (productos == null){
            productos = new ArrayList<>();
        }
        productos.add(p);
    }

    public void eliminarProducto(Producto p){
        if (productos != null){
            productos.remove(p);
        }
    }

    private boolean ordenada(List<Producto> p){
        boolean or = true;
        int i = 0;
        while (i<p.size()-1 && or){
            if (p.get(i).getPrecioDeLista()<=p.get(i+1).getPrecioDeLista()){
                or = true;
            }else{
                or = false;
            }
            i++;
        }
        return or;
    }



    public boolean isInCategoria(String codigo){
        if (productos==null){
            return false;
        }else {
            for (Producto p : productos) {
                if (codigo.equals(p.getCodigo())) {
                    return true;
                }
            }
            return false;
        }

    }

}
