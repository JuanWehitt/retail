package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateEspecificacionProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //producto.setCodigo(dto.getCodigo());
        producto.setTipo(dto.getTipo());
        Categoria categoria = categoriaDao.findCategoriaPorTipo(dto.getTipo());
        producto.setCategoria(categoria.getNombre());
        categoria.agregarProducto(producto);
        categoriaDao.save(categoria);
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
            if (!producto.getTipo().equals(dto.getTipo())){
                //asociar categoria
                Categoria categoriaNueva = categoriaDao.findCategoriaPorTipo(dto.getTipo());
                categoriaNueva.agregarProducto(producto);
                producto.setCategoria(categoriaNueva.getNombre());
            }
            producto.setOn_line(dto.isOn_line());
            producto.setPrecioOnLine(dto.getPrecioOnline());
            producto.setTipo(dto.getTipo());
            Producto productoActualizado = productoDao.updateProducto(producto);
            return productoActualizado;
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

    @Override
    public void relacionarProductos(String cod_producto1, String cod_producto2) {
        productoDao.relationProduct(cod_producto1, cod_producto2);
    }

    @Override
    public Producto updateEspecificacionProducto(String codigo, UpdateEspecificacionProductoDto dto) {
        Producto producto = productoDao.findProducto(codigo);
        if(producto!=null){
            HashMap< String, List<String> > especificaciones = producto.getEspecificaciones();
            //HashMap< String, List<String> > map = especificaciones.getMap();
            especificaciones.put(dto.getNombre(),dto.getOpciones());
            if(dto.getOpciones().size()>1) {
                producto.setPersonalizable(true);
            }
            return(productoDao.updateProducto(producto));
        }
        return null;
    }

    @Override
    public Producto deleteEspecificacionProducto(String codigo, UpdateEspecificacionProductoDto dto) {
        Producto producto = productoDao.findProducto(codigo);
        if(producto!=null) {
            HashMap< String, List<String> > especificaciones = producto.getEspecificaciones();
            if (especificaciones.containsKey(dto.getNombre())){
                //System.out.println("encontro especificaciones "+especificaciones);
                List<String> opciones = especificaciones.get(dto.getNombre());
                opciones.remove(dto.getOpciones().get(0));
                //System.out.println(opciones);
                if (opciones.size()==0){
                    especificaciones.remove(dto.getNombre());
                }
            }
            boolean configurable = false;
            for (Map.Entry< String, List<String> > entry : especificaciones.entrySet()) {
                if(entry.getValue().size()>1) {
                    configurable = true;
                    break;
                }
            }
            producto.setPersonalizable(configurable);
            return producto;
        }

        return null;
    }

}
