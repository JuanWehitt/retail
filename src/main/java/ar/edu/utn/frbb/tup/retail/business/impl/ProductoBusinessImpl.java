package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductoBusinessImpl implements ProductoBusiness {

    @Autowired
    ProductoDao productoDao;

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public Producto altaProducto(AltaProductoDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        productoDao.save(producto);
        return producto;
    }

    public Producto getProducto(String codigo) {
        Producto producto = null;
        producto = productoDao.findProducto(codigo);
        return producto;
    }

    @Override
    public Producto updateProducto(UpdateProductoDto dto, String codigo) {
        Producto producto = productoDao.findProducto(codigo);
        if (producto!=null) {
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setMarca(dto.getMarca());
            producto.setModelo(dto.getModelo());
            producto.setPrecioDeLista(dto.getPrecioDeLista());
            Categoria categoria = categoriaDao.findCategoria(dto.getCategoria());

            if(producto.getCategoria()!=null && !producto.getCategoria().getNombre().equalsIgnoreCase(dto.getCategoria())){
                Categoria categoriaActual = categoriaDao.findCategoria(producto.getCategoria().getNombre());
                categoriaActual.eliminarProducto(producto);
            }
            if(!categoria.isInCategoria(producto.getCodigo())) {
                categoria.agregarProducto(producto);
            }
            categoriaDao.updateCategoria(categoria);
            producto.setCategoria(categoria);
            producto.setEspecificaciones(dto.getEspecificaciones());
            producto.setOn_line(dto.isOn_line());
            producto.setPrecioOnLine(dto.getPrecioOnline());
            producto.setTipo(dto.getTipo());
            productoDao.updateProducto(producto);
        }
        return producto;
    }

    @Override
    public ArrayList<Producto> getProductos() {
        return productoDao.findAll();
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        return productoDao.deleteProducto(producto);
    }
}
