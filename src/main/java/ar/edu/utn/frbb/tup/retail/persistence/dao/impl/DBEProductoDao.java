package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DBEProductoDao implements ProductoDao{

    public Producto save(Producto producto) {
        return producto;
    }


    public Producto updateProducto(Producto producto) {
        return null;
    }


    public boolean deleteProducto(Producto producto) {
        return false;
    }


    public Producto findProducto(String codigo) {
        return null;
    }

    @Override
    public ArrayList<Producto> findAll() {
        return null;
    }

    @Override
    public boolean relationProduct(String cod_producto1, String cod_producto2) {
        return true;
    }
}
