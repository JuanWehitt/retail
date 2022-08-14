package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.stereotype.Component;

@Component
public class DBEProductoDao {

    public void save(Producto producto) {

    }


    public Producto updateProducto(Producto producto) {
        return null;
    }


    public boolean deleteProducto(Producto producto) {
        return false;
    }


    public Producto findProducto(String cuit) {
        return null;
    }
}
