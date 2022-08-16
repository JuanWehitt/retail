package ar.edu.utn.frbb.tup.retail.model;

public interface VendibleOnLine {
    void setPrecioOnLine(double precio);
    double getPrecioOnline();

    boolean isOn_line();
    void setOn_line(boolean valor);
}
