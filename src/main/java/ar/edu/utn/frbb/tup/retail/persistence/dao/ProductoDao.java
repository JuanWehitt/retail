package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.model.Producto;

import java.util.ArrayList;
import java.util.List;

public interface ProductoDao {
    Producto save(Producto producto);

    Producto updateProducto(Producto producto);

    boolean deleteProducto(Producto producto);

    Producto findProducto(String cuit);

    ArrayList<Producto> findAll();

    boolean relationProduct(String cod_producto1, String cod_producto2);
}
