package ar.edu.utn.frbb.tup.retail.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionTest extends TestCase {

    public void testSetOpcionElegida_ok() {
        Configuracion conf = new Configuracion("Memoria");
        conf.agregarOpcion("8GB");
        conf.agregarOpcion("16GB");
        conf.setOpcionElegida("8GB");
        assertEquals(conf.getOpcionElegida(),"8GB");
    }
}