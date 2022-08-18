package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;

public interface CategoriaBusiness {
    Categoria altaCategoria(AltaCategoriaDto dto);

    Categoria getCategoria(String nombre);
}
