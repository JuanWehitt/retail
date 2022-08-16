package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaBusinessImpl implements CategoriaBusiness {

    @Autowired
    CategoriaDao categoriaDao;


    @Override
    public Categoria altaCategoria(AltaCategoriaDto dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoriaDao.save(categoria);
        return categoria;
    }
}
