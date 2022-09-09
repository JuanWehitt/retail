package ar.edu.utn.frbb.tup.retail.dto;

public class AltaProductoDto {

    private String nombre;
    private String codigo;
    private String tipo;

    public AltaProductoDto(String nombre, String codigo, String tipo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.codigo = codigo;
        System.out.println("se creo AltaProductoDto con nombre "+nombre+", codigo "+codigo+" y tipo "+tipo );
    }

    public AltaProductoDto() {
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
