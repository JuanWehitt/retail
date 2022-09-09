package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;

import java.util.List;

public interface CategoriaBusiness {
    Categoria altaCategoria(AltaCategoriaDto dto);

    Categoria getCategoria(String nombre);

    List<Categoria> getCategorias();

    Categoria updateCategoria(UpdateCategoriaDto dto, String nombre);

    boolean deleteCategoria(String nombre);


}
