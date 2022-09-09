package ar.edu.utn.frbb.tup.retail.dto;

import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Configuracion;
import ar.edu.utn.frbb.tup.retail.model.Producto;

import java.util.List;

public class UpdateProductoDto {
    private String nombre;
    //private String categoria;
    private String marca;
    private String modelo;
    private String descripcion;
    private List<String> especificaciones;
    private double precioDeLista;
    private double precioContado;
    private boolean on_line;
    private double precioOnline;
    private List<String> configuraciones;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public String getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(String categoria) {
//        this.categoria = categoria;
//    }

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

    public List<String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<String> especificaciones) {
        this.especificaciones = especificaciones;
    }

    public double getPrecioDeLista() {
        return precioDeLista;
    }

    public void setPrecioDeLista(double precioDeLista) {
        this.precioDeLista = precioDeLista;
    }

    public double getPrecioContado() {
        return precioContado;
    }

    public void setPrecioContado(double precioContado) {
        this.precioContado = precioContado;
    }

    public boolean isOn_line() {
        return on_line;
    }

    public void setOn_line(boolean on_line) {
        this.on_line = on_line;
    }

    public double getPrecioOnline() {
        return precioOnline;
    }

    public void setPrecioOnline(double precioOnline) {
        this.precioOnline = precioOnline;
    }

    public List<String> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<String> configuraciones) {
        this.configuraciones = configuraciones;
    }
}
