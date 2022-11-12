package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.business.impl.CategoriaBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
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
    @Test
    public void test_getCategoria(){
        Categoria resultCategoria = new Categoria("testCategoria");
        Mockito.when(categoriaDaoMock.findCategoria("testCategoria")).thenReturn(resultCategoria);
        assertEquals(implementation.getCategoria("testCategoria"),
                resultCategoria);
    }
    @Test
    public void test_getCategorias(){
        Categoria resultCategoria = new Categoria("testCategoria");
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        listaCategorias.add(resultCategoria);
        Mockito.when(categoriaDaoMock.findAll()).thenReturn(listaCategorias);
        assertEquals(implementation.getCategorias(),listaCategorias);
    }
    @Test
    public void test_updateCategoria(){
        Categoria categoria = new Categoria("testCategoria");
        UpdateCategoriaDto dto = new UpdateCategoriaDto();
        dto.setNombre("testCategoria");
        dto.setDescripcion("descripcion test");
        dto.setTipos(new ArrayList<>());
        String nombre = "testCategoria";
        Mockito.when(categoriaDaoMock.findCategoria("testCategoria")).thenReturn(categoria);
        Categoria resultCategoria = implementation.updateCategoria(dto,nombre);
        assertEquals("descripcion test", resultCategoria.getDescripcion());
    }

    @Test
    public void test_deleteCategoria() {
        Mockito.when(categoriaDaoMock.deleteCategoria(Mockito.<Categoria>any())).thenReturn(true);
        assertTrue(implementation.deleteCategoria("testCategoria"));

    }
}
