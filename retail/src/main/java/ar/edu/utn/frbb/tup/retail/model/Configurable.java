package ar.edu.utn.frbb.tup.retail.model;

import java.util.List;

public interface Configurable {
    void crearListaDeOpciones(Configuracion configuracion, List<String> opciones);
    void setearOpcionElegida(Configuracion configuracion, String opcion);
}
