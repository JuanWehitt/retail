package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionBean;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody AltaCategoriaDto dto) {
        return categoriaBusiness.altaCategoria(dto);
    }

    @GetMapping("/categoria")
    public List<Categoria> getCategorias() {
        List<Categoria> categorias = null;
        categorias = categoriaBusiness.getCategorias();
        if (categorias==null){
            throw new ExceptionBean("Lista de categorias no encontrada");
        }
        return categorias;
    }

    @GetMapping("/categoria/{nombre}")
    public Categoria getCategoria(@RequestParam String nombre){
        Categoria categoria = categoriaBusiness.getCategoria(nombre);
        if (categoria!=null){
            return categoria;
        }else{
            throw new ExceptionBean("La categoria no existe");
        }
    }

    @PutMapping( value = "/categoria/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria updateCategoria(@PathVariable String nombre, @RequestBody UpdateProductoDto dto){
        Categoria categoriaActualizada = categoriaBusiness.updateCategoria(dto,nombre);
        if (categoriaActualizada==null){
            throw new ExceptionBean("Categoria "+nombre+ " no encontrada");
        }
        return categoriaActualizada;

    }


}
