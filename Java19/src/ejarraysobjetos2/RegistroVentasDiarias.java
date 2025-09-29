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
public class RegistroVentasDiarias {

    String fecha;
    Venta[] listaProductos;
    int auxPos;

    public RegistroVentasDiarias(String fecha, int capacidadMax) {
        this.fecha = fecha;
        this.listaProductos = new Venta[capacidadMax];
        this.auxPos = 0;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void imprimirRegistroVentas() {

        String codigos = "";
        String abonos = "";

        for (int i = 0; i < listaProductos.length; i++) {
            codigos += listaProductos[i].getCodProducto() + ", ";
            abonos += listaProductos[i].getAbonado() + ", ";
        }
        System.out.println("Fecha: " + fecha);

    }

    public boolean agregarVenta(Venta venta) {
        boolean agregada = false;

        if (auxPos < listaProductos.length) {
            listaProductos[auxPos] = venta;
            auxPos++;
            agregada = true;
        }

        return agregada;
    }

    public int buscarVenta(int codigo) {
        int aux=-1;
        boolean encontrada =false;
        for (int i = 0; i < listaProductos.length; i++) {
            if(codigo == listaProductos[i].getCodProducto() && !encontrada) {
                aux=i;
                encontrada = true;
            }
        }

        return aux;
    }



}
