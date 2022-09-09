package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CategoriaRestController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Autowired
    ProductoBusiness productoBusiness;

    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody AltaCategoriaDto dto) {
        return categoriaBusiness.altaCategoria(dto);
    }

//    @PostMapping(value = "/setear_categorias")
//    public List<Categoria> crearCategorias(){
//        AltaCategoriaDto dto = new AltaCategoriaDto();
//        ArrayList<String> tipos;
//        dto.setNombre("TV,Audio y Video");
//        dto.setDescripcion("Categoria que almacena productos multimedia");
//        String cadena = "televisores,cámaras de video,cámaras fotográficas,home theaters,minicomponentes,parlantes";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        System.out.println(dto.getTipos());
//        categoriaBusiness.altaCategoria(dto);
//
//        dto.setNombre("Electrodomésticos y climatización");
//        dto.setDescripcion("Categoria que almacena productos electrodomesticos");
//        cadena = "licuadoras,cafeteras,lavarropas,pavas" +
//                "eléctricas,cocinas,termotanques,aires" +
//                "acondicionados,ventiladores,calefactores";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        categoriaBusiness.altaCategoria(dto);
//        //
//        dto.setNombre("Hogar y muebles");
//        dto.setDescripcion("Categoria que almacena productos electrodomesticos");
//        cadena = "colchones,almohadas,sillas,mesas," +
//                "máquinas de cortar césped";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        categoriaBusiness.altaCategoria(dto);
//        //
//
//        dto.setNombre("Informática y electrónica");
//        dto.setDescripcion("Categoria que almacena productos de informatica y electroncia");
//        cadena = "notebooks,PC’s,monitores,impresoras," +
//                "accesorios pc’s y notebooks,celulares," +
//                "tablets,consolas de juegos";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        categoriaBusiness.altaCategoria(dto);
//        //
//        dto.setNombre("Salud y Aire libre ");
//        dto.setDescripcion("Categoria que almacena productos de Salud y Aire libre ");
//        cadena = "bicicletas,bicicletas fijas,caminadores," +
//                "carpas,conservadoras,mochilas";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        categoriaBusiness.altaCategoria(dto);
//        //
//        dto.setNombre("Otros");
//        dto.setDescripcion("Categoria que almacena productos sin categoria");
//        cadena = "";
//        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
//        dto.setTipos(tipos);
//        categoriaBusiness.altaCategoria(dto);
//        return categoriaBusiness.getCategorias();
//    }

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        List<Categoria> categorias = null;
        categorias = categoriaBusiness.getCategorias();
        if (categorias==null){
            throw new ExceptionBean("Lista de categorias no encontrada");
        }
        return categorias;
    }

    @GetMapping("/categoria/{nombre}")
    public Categoria getCategoria(@PathVariable String nombre){
        Categoria categoria = categoriaBusiness.getCategoria(nombre);
        if (categoria!=null){
            return categoria;
        }else{
            throw new ExceptionBean("La categoria no existe");
        }
    }

    @PutMapping( value = "/categoria/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria updateCategoria(@PathVariable String nombre, @RequestBody UpdateCategoriaDto dto){
        Categoria categoriaActualizada = categoriaBusiness.updateCategoria(dto,nombre);
        if (categoriaActualizada==null){
            throw new ExceptionBean("Categoria "+nombre+ " no encontrada");
        }
        return categoriaActualizada;

    }
    @DeleteMapping("/categoria/{nombre}")
    public String deleteCategoria(@PathVariable String nombre){
        Categoria categoria;
        categoria = categoriaBusiness.getCategoria(nombre);

        if (categoria==null){
            throw new ExceptionBean("Categoria con nombre  "+nombre+ " no encontrada");
        }
        try {
            if (categoriaBusiness.deleteCategoria(nombre)) {
                return "La categoria se elimino con exito";
            }else{
                return "NO se elimino la categoria por un problema interno";
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
    public ArrayList<Producto> getProductosOrder_price(@RequestParam(required = false, value = "categoria") String categoria,
                                                    @RequestParam(required = false, value = "order_price") String order_price,
                                                    @RequestParam(required = false, value = "marca") String marca,
                                                   @RequestParam(required = false, value = "precio_min") String precio_min,
                                                   @RequestParam(required = false, value = "precio_max") String precio_max) {
        Categoria c = categoriaBusiness.getCategoria(categoria);
        if (c == null) {
            List<Categoria> categorias = categoriaBusiness.getCategorias();
            Categoria todos = new Categoria();
            categorias.forEach(cat -> cat.getProductos().forEach(p -> todos.agregarProducto(p)));
            if (order_price != null) {
                return ordenadosPorPrecio(todos, order_price);
            } else if (marca != null) {
                return filtroPorMarca(todos,marca);
            } else {
                if (precio_min != null && precio_max != null) {
                    return filtroPorPrecio(todos, Double.parseDouble(precio_min), Double.parseDouble(precio_max));
                }else{
                    throw new InvalidRequestStateException("Error en los datos de entrada");
                }
            }
        }else{
            if (order_price != null) {
                return ordenadosPorPrecio(c, order_price);
            } else if (marca != null) {
                return filtroPorMarca(c, marca);
            } else {
                if (precio_min != null && precio_max != null) {
                    return filtroPorPrecio(c, Double.parseDouble(precio_min), Double.parseDouble(precio_max));
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
