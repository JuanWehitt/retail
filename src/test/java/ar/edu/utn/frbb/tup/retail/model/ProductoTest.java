package ar.edu.utn.frbb.tup.retail.model;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        double precioContado;
        precioContado = p.getPrecioDeLista() - (p.getPrecioDeLista() * Producto.getDescuentoContado());
        assertEquals(precioContado, p.getPrecioContado(),0.001);
    }
}
