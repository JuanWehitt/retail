package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusines;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusines productoBusines;


    @PostMapping( value="/producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto crearProducto(@RequestBody AltaProductoDto dto){
        return productoBusines.altaProducto(dto);
    }
    @GetMapping("/producto/{codigo}")
    public Producto getProducto(@PathVariable String codigo){
        System.out.println("se retorna el producto "+codigo);
        return productoBusines.getProducto(codigo);
    }

    @PostMapping( value = "/producto/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto updateProducto(@RequestBody UpdateProductoDto dto){
        return productoBusines.updateProducto(dto);
    }
}
