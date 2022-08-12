package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ComercioBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaComercioDto;
import ar.edu.utn.frbb.tup.retail.model.Comercio;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ComercioDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ComercioBusinessImpl implements ComercioBusiness {

    @Autowired
    ComercioDao comercioDao;
    @Override
    public Comercio altaComercio(AltaComercioDto dto) {
        Comercio comercio = new Comercio();
        comercio.setNombre(dto.getNombre());
        comercio.setCuit(dto.getCuit());
        comercio.setDireccion(dto.getDireccion());
        comercioDao.save(comercio);
        return comercio;
    }
}
