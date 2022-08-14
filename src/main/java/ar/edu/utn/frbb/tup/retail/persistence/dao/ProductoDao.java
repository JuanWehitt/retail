package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.model.Producto;

public interface ProductoDao {
    void save(Producto producto);

    Producto updateProducto(Producto producto);

    boolean deleteProducto(Producto producto);

    Producto findProducto(String cuit);

}
