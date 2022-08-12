package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.ComercioBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaComercioDto;
import ar.edu.utn.frbb.tup.retail.model.Comercio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComercioController {
    @Autowired
    ComercioBusiness comercioBusiness;

    @PostMapping( value = "/comercio", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Comercio crearComercio(@RequestBody AltaComercioDto dto){
        return comercioBusiness.altaComercio(dto);
    }
}
