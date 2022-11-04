package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CategoriaRestController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Autowired
    ProductoBusiness productoBusiness;

    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> crearCategoria(@RequestBody AltaCategoriaDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaBusiness.altaCategoria(dto));
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getCategorias() {
        List<Categoria> categorias = null;
        categorias = categoriaBusiness.getCategorias();
        if (categorias==null){
            throw new ExceptionBean("Lista de categorias no encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/categoria/{nombre}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable String nombre){
        Categoria categoria = categoriaBusiness.getCategoria(nombre);
        if (categoria!=null) return ResponseEntity.status(HttpStatus.OK).body(categoria);
        else throw new ExceptionBean("La categoria no existe");
    }

    @PutMapping( value = "/categoria/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> updateCategoria(@PathVariable String nombre, @RequestBody UpdateCategoriaDto dto){
        Categoria categoriaActualizada = categoriaBusiness.updateCategoria(dto,nombre);
        if (categoriaActualizada==null){
            throw new ExceptionBean("Categoria "+nombre+ " no encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaActualizada);

    }
    @DeleteMapping("/categoria/{nombre}")
    public ResponseEntity<String> deleteCategoria(@PathVariable String nombre){
        Categoria categoria;
        categoria = categoriaBusiness.getCategoria(nombre);

        if (categoria==null){
            throw new ExceptionBean("Categoria con nombre  "+nombre+ " no encontrada");
        }
        try {
            if (categoriaBusiness.deleteCategoria(nombre)) {
                return ResponseEntity.status(HttpStatus.OK).body("La categoria se elimino con exito");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO se elimino la categoria por un problema interno");
            }
        }catch (ExceptionCategoriaRelacionada e){

            List<Producto> listaProductos = categoriaBusiness.getCategoria(nombre).getProductos();
            List<String> listaCodigos = new ArrayList<>();
            for (Producto p: listaProductos){
                listaCodigos.add(p.getCodigo());
            }
            throw  new ExceptionCategoriaRelacionada("La categoria contiene productos relacionados que debe modificar. " +
                    "Los productos con codigo: "+ listaCodigos);
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<ArrayList<Producto>> getProductosOrder_price(@RequestParam(required = false, value = "categoria") String categoria,
                                                    @RequestParam(required = false, value = "order_price") String order_price,
                                                    @RequestParam(required = false, value = "marca") String marca,
                                                   @RequestParam(required = false, value = "precio_min") String precio_min,
                                                   @RequestParam(required = false, value = "precio_max") String precio_max) {
        Categoria c = categoriaBusiness.getCategoria(categoria);
        if (c == null) {
            String mensaje = "No se encontro la categoria, se buscara en todas.";
            List<Categoria> categorias = categoriaBusiness.getCategorias();
            Categoria todas = new Categoria();
            for (Categoria cat : categorias) {
                    for (Producto producto : cat.getProductos()) {
                        todas.agregarProducto(producto);
                    }
            }
            if (order_price != null) {
                return ResponseEntity.status(HttpStatus.OK).body(ordenadosPorPrecio(todas, order_price));
            } else if (marca != null) {
                return ResponseEntity.status(HttpStatus.OK).body(filtroPorMarca(todas,marca));
            } else {
                if (precio_min != null && precio_max != null) {
                    return ResponseEntity.status(HttpStatus.OK).body(filtroPorPrecio(todas, Double.parseDouble(precio_min), Double.parseDouble(precio_max)));
                }else{
                    throw new InvalidRequestStateException("Error en los datos de entrada");
                }
            }
        }else{
            if (order_price != null) {
                return ResponseEntity.status(HttpStatus.OK).body(ordenadosPorPrecio(c, order_price));
            } else if (marca != null) {
                return ResponseEntity.status(HttpStatus.OK).body(filtroPorMarca(c, marca));
            } else {
                if (precio_min != null && precio_max != null) {
                    return ResponseEntity.status(HttpStatus.OK).body(filtroPorPrecio(c, Double.parseDouble(precio_min), Double.parseDouble(precio_max)));
                }
                throw new InvalidRequestStateException("Error en los datos de entrada");
            }
        }
    }


    public ArrayList<Producto> ordenadosPorPrecio(Categoria categoria, String modo){
        ArrayList<Producto> productos = categoria.getProductos();
        if (productos==null){
            throw new NoSuchElementException("No hay productos asociados a la categoria");
        }
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return Double.compare(o1.getPrecioDeLista(), o2.getPrecioDeLista());
            }
        });
        if (modo.toLowerCase().charAt(0)=='a'){
            return productos;
        }else{
            Collections.reverse(categoria.getProductos());
            return productos;
        }
    }

    public ArrayList<Producto> filtroPorMarca(Categoria categoria, String marca){
        ArrayList<Producto> productos = categoria.getProductos();
        if (productos==null){
            throw new NoSuchElementException("No hay productos asociados a la categoria");
        }
        ArrayList<Producto> productosFiltro = new ArrayList<>();
        for(Producto p: productos){
            if (p.getMarca().compareToIgnoreCase(marca)==0){
                productosFiltro.add(p);
            }
        }
        return productosFiltro;
    }

    public ArrayList<Producto> filtroPorPrecio(Categoria categoria, double precioMin, double precioMax){
        ArrayList<Producto> productos = categoria.getProductos();
        if (productos==null){
            throw new NoSuchElementException("No hay productos asociados a la categoria");
        }
        ArrayList<Producto> productosFiltro = new ArrayList<>();
        for(Producto p: productos){
            if (Double.compare(p.getPrecioDeLista(),precioMin)>=0 && Double.compare(p.getPrecioDeLista(),precioMax)<=0){
                productosFiltro.add(p);
            }
        }
        return productosFiltro;
    }

}
