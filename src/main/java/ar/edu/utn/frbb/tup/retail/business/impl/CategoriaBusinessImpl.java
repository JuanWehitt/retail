package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaBusinessImpl implements CategoriaBusiness {

    @Autowired
    CategoriaDao categoriaDao;


    @Override
    public Categoria altaCategoria(AltaCategoriaDto dto) {
        Categoria categoria;
        if (categoriaDao.findCategoria(dto.getNombre())==null) {
            categoria = new Categoria();
            categoria.setNombre(dto.getNombre());
            categoria.setDescripcion(dto.getDescripcion());
            categoria.setTipos(dto.getTipos());
            categoriaDao.save(categoria);
        }else{
            categoria = categoriaDao.findCategoria(dto.getNombre());
        }
        return categoria;
    }

    @Override
    public Categoria getCategoria(String nombre) {
        return categoriaDao.findCategoria(nombre);
    }

    @Override
    public List<Categoria> getCategorias() {
        return categoriaDao.findAll();
    }

    @Override
    public Categoria updateCategoria(UpdateCategoriaDto dto, String nombre) {
        Categoria categoria = categoriaDao.findCategoria(nombre);
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setNombre(dto.getNombre());
        categoriaDao.updateCategoria(categoria);
        return categoria;
    }

    @Override
    public boolean deleteCategoria(String nombre) throws ExceptionCategoriaRelacionada {
        return categoriaDao.deleteCategoria(categoriaDao.findCategoria(nombre));
    }


}
