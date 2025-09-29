/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones;

import java.time.LocalDate;

/**
 *
 * @author huber
 */
public class Libro extends Publicacion implements Prestable {

    private boolean prestado; 
    
    public Libro(int codigo, String titulo, LocalDate año) {
        super(codigo, titulo, año);
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "prestado=" + 
                prestado +  super.toString() +'}';
    }

    
    
    
    
    
    
    
    
    @Override
    public void prestar() {
       this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public boolean prestado() {
       return this.prestado;
    }
    
}
