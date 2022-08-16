package ar.edu.utn.frbb.tup.retail.dto;

public class AltaCategoriaDto {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AltaCategoriaDto(String nombre) {
        this.nombre = nombre;
    }
}
