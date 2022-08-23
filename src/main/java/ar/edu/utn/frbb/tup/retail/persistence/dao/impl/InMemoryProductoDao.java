package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class InMemoryProductoDao implements ProductoDao {
    private ArrayList<Producto> productosList = new ArrayList<>();

    @Override
    public Producto save(Producto producto) {
        productosList.add(producto);
        System.out.println("se almaceno en memoria un producto "+producto.getCodigo());
        return producto;
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return null;
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        return productosList.remove(producto);
    }

    @Override
    public Producto findProducto(String codigo) {
        Producto encontrado = null;
        for (Producto p: productosList){
            if(p.getCodigo().equals(codigo)){
                encontrado = p;
                System.out.println("Encontro producto con "+codigo);
            }
        }
        return encontrado;
    }

    @Override
    public ArrayList<Producto> findAll() {
        return productosList;
    }


}
