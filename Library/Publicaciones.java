/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author huber
 */
public class Publicaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Publicacion> listaPublicaciones = new ArrayList();

        Libro manuel = new Libro(1, "El Libro de Manuel", LocalDate.of(1910, Month.MARCH, 10));
        Revista jose = new Revista(2, 3, "La revista de Jose", LocalDate.of(1920, Month.MARCH, 15));
        Revista sara = new Revista(4, 5, "La revista de Sara", LocalDate.of(1930, Month.MARCH, 20));
        Libro clara = new Libro(6, "El Libro de Clara", LocalDate.of(2000, Month.MARCH, 30));

        listaPublicaciones.add(manuel);
        listaPublicaciones.add(jose);
        listaPublicaciones.add(sara);
        listaPublicaciones.add(clara);
        
        
    }
    public static int cuentaPrestado(ArrayList<Publicacion> listaPublicaciones) {
        int cantidad = 0;
        
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            //si es una instancia de libro
            if(listaPublicaciones.get(i) instanceof Libro) {
               if(((Libro) listaPublicaciones.get(i)).prestado()) {
                   cantidad++;
               }
            }
        }
        return cantidad;
    }
    public static int cuentaRevistas(ArrayList<Publicacion> listaPublicaciones) {
        int cantidad = 0;
        
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            if(listaPublicaciones.get(i) instanceof Libro) {
                if(((Libro) listaPublicaciones.get(i)).prestado()) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }
    public static int publicacionesAnterioresA(ArrayList<Publicacion> listaPublicaciones, LocalDate año) {
        int cantidad = 0;
        
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            if(listaPublicaciones.get(i).getAño().compareTo(año) <0) {
                cantidad++;
            }
        }
        return cantidad;
    }
      public static void imprimirPublicaciones(ArrayList<Publicacion> array) {
         for (int i = 0; i < array.size() ; i++) {
              
                  System.out.println(( array.get(i)).toString());
            
            
         }
     }
}
