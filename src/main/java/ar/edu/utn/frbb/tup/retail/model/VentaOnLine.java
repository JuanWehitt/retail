package ar.edu.utn.frbb.tup.retail.model;

public class VentaOnLine implements Venta{

    private Producto producto;
    private Configuracion configuracion;

    public void VentaOnline(Producto p, Configuracion conf){
        producto = p;
    }

    @Override
    public void crearVenta(Producto p, Configuracion c, String idClient) {

    }
}
