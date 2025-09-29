/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarraysobjetos2;

/**
 *
 * @author hz
 */
public class Venta {

    private int codProducto;
    private double abonado;

    public Venta(int codProducto, double abonado) {
        this.codProducto=codProducto;
        this.abonado=abonado;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public double getAbonado() {
        return abonado;
    }

    public void setAbonado(double abonado) {
        this.abonado = abonado;
    }

    public void imprimirDatos() {
        System.out.println("Código: "+codProducto);
        System.out.println("Abonado: "+abonado);
    }

}
