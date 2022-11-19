package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;

public class Categoria {
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> productos;
    private ArrayList<String> tipos;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.tipos = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public Categoria() {
        this.tipos = new ArrayList<>();
        this.productos = new ArrayList<>();
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

    public void setTipos(ArrayList<String> tipos) {
        this.tipos.addAll(tipos);
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }
}
