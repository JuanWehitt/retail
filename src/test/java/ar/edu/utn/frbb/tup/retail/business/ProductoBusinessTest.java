package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.business.impl.ProductoBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ProductoBusinessTest {

    @Mock
    ProductoDao daoMock;

    @Mock
    CategoriaDao categoriaDaoMock;

    @InjectMocks
    ProductoBusinessImpl implementation;

    @Test
    public void test_altaProducto() {
        Categoria categoria = new Categoria();
        categoria.setNombre("testCategoria");

        AltaProductoDto dto = new AltaProductoDto("testProducto","1234","parlantes");
        Mockito.when(daoMock.save(Mockito.<Producto>any())).thenReturn(new Producto());
        Mockito.when(categoriaDaoMock.findCategoria("audio")).thenReturn(categoria);

        Producto resultProducto = implementation.altaProducto(dto);

        assertEquals(1, categoria.getProductos().size());

    }
}
