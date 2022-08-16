package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Categoria {
    private String nombre;
    private ArrayList<Producto> productos;


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
    public ArrayList<Producto> ordenadosPorPrecio(String modo){
        Collections.sort(this.productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return Double.compare(o1.getPrecioDeLista(),o2.getPrecioDeLista());
            }
        });
        if (modo.toLowerCase().charAt(0)=='a'){
            return this.productos;
        }else{
            Collections.reverse(productos);
            return productos;
        }

    }
    public ArrayList<Producto> filtroPorMarca(String marca){
        ArrayList<Producto> productosFiltro = new ArrayList<>();
        for(Producto p: productos){
            if (p.getMarca().compareTo(marca)==0){
                productosFiltro.add(p);
            }
        }
        return productosFiltro;
    }
    public ArrayList<Producto> filtroPorPrecio(double precio){
        ArrayList<Producto> productosFiltro = new ArrayList<>();
        for(Producto p: productos){
            if (Double.compare(p.getPrecioDeLista(),precio)==0){
                productosFiltro.add(p);
            }
        }
        return productosFiltro;
    }

}
