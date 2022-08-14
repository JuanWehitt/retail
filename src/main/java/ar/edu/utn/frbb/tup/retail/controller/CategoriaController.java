package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaBusiness categoriaBusiness;

    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody AltaCategoriaDto dto) {
        return categoriaBusiness.altaCategoria(dto);
    }
}
