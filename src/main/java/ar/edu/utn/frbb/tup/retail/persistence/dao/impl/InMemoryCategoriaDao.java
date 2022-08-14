package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoriaDao implements CategoriaDao {
    private List<Categoria> categoriasList = new ArrayList<>();
    @Override
    public void save(Categoria categoria) {

    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public boolean deleteCategoria(Categoria categoria) {
        return false;
    }

    @Override
    public Categoria findCategoria(String nombre) {
        return null;
    }
}
