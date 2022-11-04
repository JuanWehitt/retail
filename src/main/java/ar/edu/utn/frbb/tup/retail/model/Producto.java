package ar.edu.utn.frbb.tup.retail.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Producto implements VendibleOnLine {
    private String codigo;
    private String nombre;
    private String categoria;
    private String marca="";
    private String modelo="";
    private String descripcion="";
    HashMap< String, List<String> > especificaciones = new HashMap < String, List<String> > ();
    private double precioDeLista;
    private double precioContado;
    private boolean on_line = false;
    private double precioOnline;
    private static double descuentoOnline;
    private List<String> relacionados = new ArrayList<>();
    private String tipo;
    private boolean personalizable = false;
    private static double descuentoContado = 0.15;

    public Producto(){}

    public Producto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public boolean isPersonalizable() {
        return personalizable;
    }

    public void setPersonalizable(boolean personalizable) {
        this.personalizable = personalizable;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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

    public List<String> getRelacionados() {
        return relacionados;
    }

    public void agregarRelacionado(String cod_rel){
        if(relacionados==null){
            relacionados = new ArrayList<>();
            relacionados.add(cod_rel);
        }
        if(!relacionados.contains(cod_rel)){
            relacionados.add(cod_rel);
        }
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

    public HashMap< String, List<String> > getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(HashMap< String, List<String> > especificaciones) {
        this.especificaciones = especificaciones;
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

    public Producto (Producto aCopiar){
        this.codigo = aCopiar.getCodigo();
        this.nombre = aCopiar.getNombre();
        this.categoria = aCopiar.getCategoria();
        this.marca = aCopiar.getMarca();
        this.modelo = aCopiar.getModelo();
        this.descripcion = aCopiar.getDescripcion();
        this.precioDeLista = aCopiar.getPrecioDeLista();
        this.precioContado = aCopiar.getPrecioContado();
        this.on_line = aCopiar.isOn_line();
        this.precioOnline = aCopiar.getPrecioOnline();
        this.relacionados = aCopiar.getRelacionados().subList(0,aCopiar.getRelacionados().size()-1);
        this.tipo = aCopiar.getTipo();
        this.personalizable = aCopiar.isPersonalizable();

    }

}
