package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusines;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoBusinessImpl implements ProductoBusines {

    @Autowired
    ProductoDao productoDao;
    @Override
    public Producto altaProducto(AltaProductoDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        productoDao.save(producto);
        return producto;
    }
}
