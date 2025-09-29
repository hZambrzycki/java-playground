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
public class Revista extends Publicacion {
  private int numero;

    @Override
    public String toString() {
        return "Revista{" + "numero=" + numero + super.toString()+ '}';
    }

    public Revista(int numero, int codigo, String titulo, LocalDate año) {
        super(codigo, titulo, año);
        if(numero >0) {
          this.numero = numero;
        } else {
            throw new IllegalArgumentException("El codigo tiene que ser positivo");
        }
     
    }
    
}
