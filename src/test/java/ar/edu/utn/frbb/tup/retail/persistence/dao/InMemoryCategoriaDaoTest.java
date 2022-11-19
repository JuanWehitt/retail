package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.impl.InMemoryCategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.impl.InMemoryProductoDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InMemoryCategoriaDaoTest {

    @InjectMocks
    InMemoryCategoriaDao inMemoryCategoriaDao;

    @Test
    public void test_saveOk(){
        Categoria categoria = new Categoria("Electrodomesticos");
        inMemoryCategoriaDao.save(categoria);
        assertEquals(7,inMemoryCategoriaDao.findAll().size());
    }

    @Test
    public void test_deleteOk(){
        Categoria categoria = new Categoria("Electrodomesticos");
        Categoria categoria2 = inMemoryCategoriaDao.save(categoria);
        assertTrue(inMemoryCategoriaDao.deleteCategoria(categoria2));
    }

    @Test
    public void test_deleteFail(){
        Producto producto = new Producto("plancha","123");
        Categoria categoria = new Categoria("cat1");
        categoria.agregarProducto(producto);
        Categoria categoria2 = inMemoryCategoriaDao.save(categoria);
        assertThrows(ExceptionCategoriaRelacionada.class, ()-> {inMemoryCategoriaDao.deleteCategoria(categoria2);});

    }
}
