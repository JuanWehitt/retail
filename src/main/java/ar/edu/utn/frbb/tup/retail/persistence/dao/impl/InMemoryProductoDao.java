package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InMemoryProductoDao implements ProductoDao {
    private ArrayList<Producto> productosList = new ArrayList<>();

    @Override
    public Producto save(Producto producto) {
        String codigo = generarCodigo();
        producto.setCodigo(codigo);
        System.out.println("Se almaceno en memoria un producto "+producto.getCodigo());
        productosList.add(producto);
        return producto;
    }

    private String generarCodigo() {
        return UUID.randomUUID().toString().toUpperCase().substring(0,6);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto p = this.findProducto(producto.getCodigo());
        if (p!=null) {
            p.setCategoria(producto.getCategoria());
            p.setTipo(producto.getTipo());
            p.setPrecioDeLista(producto.getPrecioDeLista());
            p.setDescripcion(producto.getDescripcion());
            p.setNombre(producto.getNombre());
            p.setEspecificaciones(producto.getEspecificaciones());
            p.setMarca(producto.getMarca());
            p.setOn_line(producto.isOn_line());
            p.setPersonalizable(producto.isPersonalizable());
            p.setPrecioOnLine(producto.getPrecioOnline());
            p.setModelo(producto.getModelo());
        }
        return p;
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        return productosList.remove(producto);
    }

    @Override
    public Producto findProducto(String codigo) {
        Producto encontrado = null;
        for (Producto p: productosList){
            if(p.getCodigo().equals(codigo)){
                encontrado = p;
                System.out.println("Encontro producto con "+codigo);
            }
        }
        return encontrado;
    }

    @Override
    public ArrayList<Producto> findAll() {
        return productosList;
    }

    @Override
    public boolean relationProduct(String cod_producto1, String cod_producto2) {
        Producto p1 = findProducto(cod_producto1);
        Producto p2 = findProducto(cod_producto2);
        if( p1!= null && p2 != null){
            p1.agregarRelacionado(p2.getCodigo());
            p2.agregarRelacionado(p1.getCodigo());
            return true;
        }else{
            return false;
        }
    }


}
