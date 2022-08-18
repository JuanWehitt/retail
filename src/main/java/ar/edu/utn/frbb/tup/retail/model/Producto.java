package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.List;

public class Producto implements Configurable, VendibleOnLine {
    private String codigo;
    private String nombre;
    private Categoria categoria;
    private String marca;
    private String modelo;
    private String descripcion;
    private List<String> especificaciones;
    private double precioDeLista;
    private double precioContado;
    private boolean on_line = false;
    private double precioOnline;
    private static double descuentoOnline;
    private List<Producto> relacionados;
    private String tipo;

    private List<Configuracion> configuraciones;
    private static double descuentoContado = 0.15;

    public Producto (Producto aCopiar){
        this.codigo = aCopiar.getCodigo();
        this.nombre = aCopiar.getNombre();
        this.categoria = new Categoria(aCopiar.getCategoria().getNombre());
        this.marca = aCopiar.getMarca();
        this.modelo = aCopiar.getModelo();
        this.descripcion = aCopiar.getDescripcion();
        this.especificaciones = aCopiar.getEspecificaciones().subList(0,aCopiar.getEspecificaciones().size()-1);
        this.precioDeLista = aCopiar.getPrecioDeLista();
        this.precioContado = aCopiar.getPrecioContado();
        this.on_line = aCopiar.isOn_line();
        this.precioOnline = aCopiar.getPrecioOnline();
        this.relacionados = aCopiar.getRelacionados().subList(0,aCopiar.getRelacionados().size()-1);
        this.configuraciones = aCopiar.getConfiguraciones().subList(0,aCopiar.getConfiguraciones().size()-1);
        this.tipo = aCopiar.getTipo();
    }

    public Producto(){

    }
    public Producto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public double getPrecioDeLista() {
        return precioDeLista;
    }

    public void setPrecioDeLista(double precioDeLista) {
        this.precioDeLista = precioDeLista;
    }

    public double getPrecioContado() {
        precioContado = this.precioDeLista - this.precioDeLista * descuentoContado;
        return precioContado;
    }

    public boolean isOn_line() {
        return on_line;
    }

    public void setOn_line(boolean valor) {
        this.on_line = valor;
    }

    public List<Producto> getRelacionados() {
        return relacionados;
    }

    public void agregarRelacionado(Producto rel){
        if(relacionados==null){
            relacionados = new ArrayList<>();
        }
        relacionados.add(rel);
    }

    public static double getDescuentoContado() {
        return descuentoContado;
    }

    public static void setDescuentoContado(double descuento) {
        Producto.descuentoContado = descuento;
    }

    public static double getDescuentoOnline() {
        return descuentoOnline;
    }

    public static void setDescuentoOnline(double descuentoOnline) {
        Producto.descuentoOnline = descuentoOnline;
    }

    public double precioOnline(){
        return this.precioDeLista - precioDeLista * descuentoOnline;
    }

    public List<Configuracion> getConfiguraciones() {
        return configuraciones;
    }

    public List<String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<String> especificaciones) {
        if (this.especificaciones==null ){
            this.especificaciones = new ArrayList<>();
        }
        this.especificaciones = especificaciones;
    }

    public void agregarConfiguracion(Configuracion conf){
        if(configuraciones==null) {
            configuraciones = new ArrayList<>();
        }
        this.configuraciones.add(conf);
        if (especificaciones == null) {
            this.especificaciones = new ArrayList<>();
        }
        this.especificaciones.add(conf.getNombre() + ":" + conf.getOpcionElegida());

    }

    @Override
    public void crearListaDeOpciones(Configuracion configuracion, List<String> opciones) {
        for (String opcion: opciones) {
            configuracion.agregarOpcion(opcion);
        }
    }

    @Override
    public void setearOpcionElegida(Configuracion configuracion, String opcion) {
        configuracion.setOpcionElegida(opcion);
    }

    @Override
    public void setPrecioOnLine(double precio) {
        this.precioOnline = precio;
    }

    @Override
    public double getPrecioOnline() {
        if (this.on_line) {
            return precioOnline;
        }else{
            return 0;
        }
    }


}
