package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryCategoriaDao implements CategoriaDao {
    private List<Categoria> categoriasList = new ArrayList<>();
    @Override
    public void save(Categoria categoria) {
        categoriasList.add(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public boolean deleteCategoria(Categoria categoria) {
        return categoriasList.remove(categoria);
    }

    @Override
    public Categoria findCategoria(String nombre) {
        Categoria encontrada = null;
        for (Categoria c: categoriasList){
            if(c.getNombre().equals(nombre)){
                encontrada = c;
                System.out.println("Encontro producto con "+nombre);
            }
        }
        return encontrada;
    }
}
