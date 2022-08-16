package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusines;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
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

    public Producto getProducto(String codigo){
        return productoDao.findProducto(codigo);
    }

    @Override
    public Producto updateProducto(UpdateProductoDto dto) {
        Producto producto = productoDao.findProducto(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setMarca(dto.getMarca());
        producto.setModelo(dto.getModelo());
        producto.setPrecioDeLista(dto.getPrecioDeLista());
        producto.setCategoria(dto.getCategoria());
        producto.setEspecificaciones(dto.getEspecificaciones());
        producto.setOn_line(dto.isOn_line());
        producto.setPrecioOnLine(dto.getPrecioOnline());
        return producto;
    }
}
