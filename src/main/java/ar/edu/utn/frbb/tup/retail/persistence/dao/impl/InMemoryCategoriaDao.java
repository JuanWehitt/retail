package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class InMemoryCategoriaDao implements CategoriaDao {
    private List<Categoria> categoriasList = new ArrayList<>();

    @Override
    public Categoria save(Categoria categoria) {
        categoriasList.add(categoria);
        return categoria;
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return categoria;
    }

    @Override
    public boolean deleteCategoria(Categoria categoria) throws ExceptionCategoriaRelacionada{
        if (categoriasList.get(categoriasList.indexOf(categoria)).getProductos().size()!=0){
            throw new ExceptionCategoriaRelacionada("La categoria contiene productos asociados");
        }else {
            return categoriasList.remove(categoria);
        }
    }

    @Override
    public Categoria findCategoria(String nombre) {
        Categoria encontrada = null;
        for (Categoria c: categoriasList){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                encontrada = c;
                System.out.println("Encontro categoria con "+nombre);
            }
        }
        return encontrada;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriasList;
    }

    @Override
    public Categoria findCategoriaPorTipo(String tipo) {
        for( Categoria cat : categoriasList){
            if (cat.getTipos().contains(tipo)){
                return cat;
            }
        }
        return findCategoria("otros");
    }
}
