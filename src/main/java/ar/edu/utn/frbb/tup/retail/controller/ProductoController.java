package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusines;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
@RestController
public class ProductoController {

    @Autowired
    ProductoBusines productoBusines;

    @PostMapping( value="/producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto crearProducto(@RequestBody AltaProductoDto dto){
        return productoBusines.altaProducto(dto);
    }
}
