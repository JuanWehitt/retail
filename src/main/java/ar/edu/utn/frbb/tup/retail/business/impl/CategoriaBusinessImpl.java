package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaBusinessImpl implements CategoriaBusiness {

    @Autowired
    CategoriaDao categoriaDao;


    @Override
    public Categoria altaCategoria(AltaCategoriaDto dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoriaDao.save(categoria);
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
    public Categoria updateCategoria(UpdateProductoDto dto, String nombre) {
        Categoria categoria = categoriaDao.findCategoria(nombre);
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setNombre(dto.getNombre());
        categoriaDao.updateCategoria(categoria);
        return categoria;
    }
}
