/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proypublicaciones;

/**
 *
 * @author ANA
 */
public class Libro extends Publicacion implements Prestable {
    
    private boolean prestado;

    public Libro(String codigo, String titulo, int año) {
        super(codigo, titulo, año);
        prestado = false;
    }

    @Override
    public void prestar() {
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }

    @Override
    public boolean prestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString() + "prestado=" + prestado + '}';
    }
    
}
