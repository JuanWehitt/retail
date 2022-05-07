package ar.edu.utn.frbb.tup.retail.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProductoTest {

    @Test
    public void testsetPrecioDeLista_ok() {
        Producto p = new Producto("0001","Televisor aa");
        p.setPrecioDeLista(15999.90);
        assertTrue(p.getPrecioDeLista()>0.0);
    }
    @Test
    public void testsetPrecioContado_ok() {
        Producto p = new Producto("0001","Televisor bb");
        p.setPrecioDeLista(15999.90);
        assertTrue((p.getPrecioContado() - (p.getPrecioContado() * Producto.getDescuentoContado())) == p.getPrecioDeLista());
    }
    @Test
    public void testAgregarConfiguracion_ok() {
        Producto p = new Producto("0001","Televisor bb");
        Configuracion conf = new Configuracion("Ram");
        p.agregarConfiguracion(conf);
        List<String> listaConf = new ArrayList<>();
        listaConf.add("4GB");
        listaConf.add("8GB");
        listaConf.add("16GB");
        p.crearListaDeOpciones(conf,listaConf);
        assertNotNull(p.getConfiguraciones());

    }
}
