package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;

public interface ProductoBusines {
    Producto altaProducto(AltaProductoDto dto);
}
