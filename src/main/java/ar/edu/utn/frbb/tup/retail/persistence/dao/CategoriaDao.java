package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.model.Categoria;

import java.util.List;

public interface CategoriaDao {
    Categoria save(Categoria categoria);

    Categoria updateCategoria(Categoria categoria);

    boolean deleteCategoria(Categoria categoria);

    Categoria findCategoria(String nombre);

    List<Categoria> findAll();

    Categoria findCategoriaPorTipo(String tipo);
}
