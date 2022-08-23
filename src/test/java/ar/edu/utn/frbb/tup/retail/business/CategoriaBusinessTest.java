package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.business.impl.CategoriaBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CategoriaBusinessTest {

    @Mock
    CategoriaDao categoriaDaoMock;

    @InjectMocks
    CategoriaBusinessImpl implementation;

    @Test
    public void test_altaCategoria(){

        AltaCategoriaDto dto = new AltaCategoriaDto("testCategoria");
        Mockito.when(categoriaDaoMock.findCategoria("testCategoria")).thenReturn(null);

        Categoria resultCategoria = implementation.altaCategoria(dto);

        assertEquals("testCategoria", resultCategoria.getNombre());
    }

}
