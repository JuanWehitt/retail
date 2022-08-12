package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.dto.AltaComercioDto;
import ar.edu.utn.frbb.tup.retail.model.Comercio;

public interface ComercioBusiness {
    Comercio altaComercio(AltaComercioDto dto);
}
