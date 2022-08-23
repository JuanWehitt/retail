package ar.edu.utn.frbb.tup.retail.persistence.dao;

import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.impl.InMemoryCategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.impl.InMemoryProductoDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class InMemoryProductoDaoTest {


    @InjectMocks
    InMemoryProductoDao inMemoryProductoDao;

    @Test
    public void test_saveOk(){
        Producto producto = new Producto("1234","plancha");
        inMemoryProductoDao.save(producto);
        assertEquals(1,inMemoryProductoDao.findAll().size());
    }

    @Test
    public void test_deleteOk(){
        Producto producto = new Producto("1234","plancha");
        Producto producto2 = inMemoryProductoDao.save(producto);
        assertTrue(inMemoryProductoDao.deleteProducto(producto2));
    }
}
