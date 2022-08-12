package ar.edu.utn.frbb.tup.retail.dto;

public class AltaComercioDto {
    private String nombre;
    private String cuit;

    private String direccion;

    public AltaComercioDto(String nombre, String cuit, String direccion) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
