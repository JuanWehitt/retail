package ar.edu.utn.frbb.tup.retail.business;

import ar.edu.utn.frbb.tup.retail.business.impl.ProductoBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateEspecificacionProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ProductoBusinessTest {

    @Mock
    ProductoDao productoDaoMock;

    @Mock
    CategoriaDao categoriaDaoMock;

    @InjectMocks
    ProductoBusinessImpl implementation;

    @Test
    public void test_altaProducto() {
        Categoria categoria = new Categoria();
        categoria.setNombre("testCategoria");

        AltaProductoDto dto = new AltaProductoDto("testProducto","parlantes");
        Mockito.when(productoDaoMock.save(Mockito.<Producto>any())).thenReturn(new Producto());
        Mockito.when(categoriaDaoMock.findCategoriaPorTipo("parlantes")).thenReturn(categoria);

        Producto resultProducto = implementation.altaProducto(dto);

        assertEquals(1, categoria.getProductos().size());

    }

    @Test
    public void test_getProducto(){
        Producto resultProducto = new Producto();
        resultProducto.setCodigo("AA231");
        Mockito.when(productoDaoMock.findProducto("AA231")).thenReturn(resultProducto);
        assertEquals(implementation.getProducto("AA231"),
                resultProducto);
    }

    @Test
    public void test_getProductos(){
        Producto resultProducto = new Producto();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(resultProducto);
        Mockito.when(productoDaoMock.findAll()).thenReturn(listaProductos);
        assertEquals(implementation.getProductos(),listaProductos);
    }

    @Test
    public void test_updateProducto(){
        Producto producto = new Producto();
        producto.setCodigo("AA322");
        producto.setNombre("Nombre");
        producto.setTipo("parlantes");
        UpdateProductoDto dto = new UpdateProductoDto();
        dto.setNombre("nombre test");
        dto.setTipo("parlantes");
        String codigo = "AA322";
        Mockito.when(productoDaoMock.findProducto("AA322")).thenReturn(producto);
        Mockito.when(productoDaoMock.updateProducto(producto)).thenReturn(producto);
        Producto resultProducto = implementation.updateProducto(dto,codigo);
        assertEquals("nombre test", resultProducto.getNombre());
    }

    @Test
    public void test_deleteProducto(){
        Producto producto = new Producto();
        Mockito.when(productoDaoMock.deleteProducto(Mockito.<Producto>any())).thenReturn(true);
        assertTrue(implementation.deleteProducto(producto));
    }

    @Test
    public void test_relacionarProductos(){
        Mockito.when(productoDaoMock.relationProduct("AA323","AA324")).thenReturn(true);
        assertTrue(implementation.relacionarProductos("AA323","AA324"));
    }

    @Test
    public void test_updateEspecificacionProducto(){
        Producto producto = new Producto();
        producto.setCodigo("AA343");
        Mockito.when(productoDaoMock.findProducto(producto.getCodigo())).thenReturn(producto);
        ArrayList opciones = new ArrayList<String>();
        opciones.add("blanco");
        UpdateEspecificacionProductoDto UpdateDto = new UpdateEspecificacionProductoDto("color",opciones);
        Mockito.when(productoDaoMock.updateProducto(Mockito.<Producto>any())).thenReturn(producto);
        Producto productoUpdate = implementation.updateEspecificacionProducto("AA343",UpdateDto);
        String cualidad = productoUpdate.getEspecificaciones().get("color").get(0);
        assertEquals("blanco",cualidad);
    }

    @Test
    public void test_deleteEspecificacionProducto(){
        Producto producto = new Producto();
        producto.setCodigo("AA343");
        Mockito.when(productoDaoMock.findProducto(producto.getCodigo())).thenReturn(producto);
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("blanco");
        UpdateEspecificacionProductoDto UpdateDto = new UpdateEspecificacionProductoDto("color",opciones);
        Mockito.when(productoDaoMock.updateProducto(Mockito.<Producto>any())).thenReturn(producto);
        Producto productoUpdate = implementation.updateEspecificacionProducto("AA343",UpdateDto);
        Producto productoConDelEsp = implementation.deleteEspecificacionProducto("AA343",UpdateDto);
        assertEquals(0,productoConDelEsp.getEspecificaciones().size());
    }

}
