package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @PostMapping( value="/producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto crearProducto(@RequestBody AltaProductoDto dto){
        return productoBusiness.altaProducto(dto);
    }

    @GetMapping("/producto")
    public List<Producto> getProductos() {
        List<Producto> productos = null;
        productos = productoBusiness.getProductos();
        if (productos==null){
            throw new ExceptionBean("Lista de productos no encontrada");
        }
        return productos;
    }

    @GetMapping("/producto/{codigo}")
    public Producto getProducto(@PathVariable String codigo) {
        Producto producto = null;
        producto = productoBusiness.getProducto(codigo);
        if (producto==null){
            throw new ExceptionBean("Producto "+codigo+ " no encontrado");
        }
        return producto;
    }
    @GetMapping("/producto/por_tipo_marca_categoria")
    public List<Producto> listarPorTipoMarcaCategoria(@RequestParam("tipo_producto") String tipo,
                                                       @RequestParam("marca") String marca,
                                                       @RequestParam("categoria") String categoria){
        List<Producto> listaAMostrar;
        if (!tipo.equals("")) {
            if (!marca.equals("")) {
                if (!categoria.equals("")) {
                    listaAMostrar = listarProductosTipoMarcaCategoria(tipo,marca,categoria);
                    if (listaAMostrar.size()==0){
                        throw new ExceptionBean("No se encontraron resultados");
                    }else{
                        return listaAMostrar;
                    }
                }else{
                    throw new ExceptionBean("No especifico los datos de categoria");
                }
            }else{
                throw new ExceptionBean("No especifico los datos de marca");
            }
        }else{
            throw new ExceptionBean("No especifico los datos de tipo");
        }
    }

    @PutMapping( value = "/producto/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto updateProducto(@PathVariable String codigo, @RequestBody UpdateProductoDto dto){
        if(categoriaBusiness.getCategoria(dto.getCategoria())== null){
            AltaCategoriaDto dtoAltaCategoria = new AltaCategoriaDto(dto.getCategoria());
            categoriaBusiness.altaCategoria(dtoAltaCategoria);
        }
        Producto productoActualizado = productoBusiness.updateProducto(dto,codigo);
        if (productoActualizado==null){
            throw new ExceptionBean("Producto "+codigo+ " no encontrado");
        }
        if(productoActualizado!=null){
            return productoActualizado;
        }else{
            return new Producto();
        }
    }
    @DeleteMapping("/producto/{codigo}")
    public String deleteProducto(@PathVariable String codigo){
        Producto producto;
        producto = productoBusiness.getProducto(codigo);
        if (producto==null){
            throw new ExceptionBean("Producto "+codigo+ " no encontrado");
        }
        if (productoBusiness.deleteProducto(producto)){
            return "El producto se elimino con exito";
        }else{
            return "Ocurrio un error al eliminar el producto";
        }
    }

    private List<Producto> listarProductosTipoMarcaCategoria(String tipo,String marca, String categoria){
        ArrayList<Producto> listaProductos = productoBusiness.getProductos();
        List<Producto> listaFiltrada = new ArrayList<>();
        for(Producto producto : listaProductos){
            //System.out.println("Comparando "+producto.toString());
            if(producto.getTipo().equalsIgnoreCase(tipo) &&
                producto.getMarca().equalsIgnoreCase(marca) &&
                producto.getCategoria().getNombre().equalsIgnoreCase(categoria)){
                listaFiltrada.add(producto);
                //System.out.println("Encontro y almaceno "+producto.toString());
            }
        }
        return listaFiltrada;
    }
}
