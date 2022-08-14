package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.model.Categoria;

public interface CategoriaDao {
    void save(Categoria categoria);

    Categoria updateCategoria(Categoria categoria);

    boolean deleteCategoria(Categoria categoria);

    Categoria findCategoria(String nombre);
}
