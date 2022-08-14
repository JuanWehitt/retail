package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;

public interface ProductoBusines {
    Producto altaProducto(AltaProductoDto dto);
    Producto getProducto(String codigo);

    Producto updateProducto(UpdateProductoDto dto);
}
