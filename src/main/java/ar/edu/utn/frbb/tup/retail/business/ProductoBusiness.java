package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;

import java.util.ArrayList;

public interface ProductoBusiness {
    Producto altaProducto(AltaProductoDto dto);
    Producto getProducto(String codigo);

    Producto updateProducto(UpdateProductoDto dto, String codigo);

    ArrayList<Producto> getProductos();

    boolean deleteProducto(Producto producto);

    void relacionarProductos(String cod_producto1, String cod_producto2);
}
