package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateEspecificacionProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;

import java.util.ArrayList;

public interface ProductoBusiness {
    Producto altaProducto(AltaProductoDto dto);

    Producto getProducto(String codigo);

    Producto updateProducto(UpdateProductoDto dto, String codigo);

    ArrayList<Producto> getProductos();

    boolean deleteProducto(Producto producto);

    boolean relacionarProductos(String cod_producto1, String cod_producto2);

    Producto updateEspecificacionProducto(String codigo, UpdateEspecificacionProductoDto dto);

    Producto deleteEspecificacionProducto(String codigo, UpdateEspecificacionProductoDto dto);
}
