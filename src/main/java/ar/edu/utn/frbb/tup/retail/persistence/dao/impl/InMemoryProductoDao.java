package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryProductoDao implements ProductoDao {
    private List<Producto> productosList = new ArrayList<>();

    @Override
    public void save(Producto producto) {

    }

    @Override
    public Producto updateProducto(Producto producto) {
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
