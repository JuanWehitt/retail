package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;

public class DBEProductoDao implements ProductoDao {
    @Override
    public void save(Producto producto) {

    }

    @Override
    public Producto updateProductp(Producto producto) {
        return null;
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        return false;
    }

    @Override
    public Producto findProducto(String cuit) {
        return null;
    }
}
