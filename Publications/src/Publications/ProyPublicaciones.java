/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proypublicaciones;

import java.util.ArrayList;

/**
 *
 * @author ANA
 */
public class ProyPublicaciones {

    /**
     * @param listaLibros
     * @param args the command line arguments
     * @return
     */
    //Falta contarPublicaciones
    public static int cuentaPrestados(ArrayList<Publicacion> listaPublicaciones) {
        int cont = 0;
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            if ((listaPublicaciones.get(i) instanceof Libro)
                    && ((Libro) listaPublicaciones.get(i)).prestado()) {
                cont++;
            }
        }
        return cont;

    }

    public static int cuentaRevistas(ArrayList<Publicacion> listaPublicaciones) {
        int cont = 0;
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            if (listaPublicaciones.get(i) instanceof Revista) {
                cont++;
            }
        }
        return cont;

    }

    public static int publicacionesAnterioresA(
            ArrayList<Publicacion> listaPublicaciones,
            int año) {
        int cont = 0;
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            if (listaPublicaciones.get(i).getAño() < año) {
                cont++;
            }
        }
        return cont;
    }
    
    public static void imprimirPublicaciones( ArrayList<Publicacion> 
            listaPublicaciones){
        for (int i=0; i<listaPublicaciones.size(); i++) {
            if (listaPublicaciones.get(i) instanceof Libro) {
                System.out.println("LIBRO");
            }
            else {
                System.out.println("REVISTA");
            }
            System.out.println(listaPublicaciones.get(i));
        }
    }


    public static void main(String[] args) {
        // TODO code application logic here
        Libro quijote = new Libro("1", "Don Quijote de la Mancha", 1605);
        Libro harryPotter = new Libro("2", "HarryPotter y la Piedra Filosofal",
                1997);

        Revista science = new Revista(2, "3", "Science", 2005);
        Revista nature = new Revista(3, "4", "Nature", 2000);

        ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

        listaPublicaciones.add(quijote);
        listaPublicaciones.add(harryPotter);

        listaPublicaciones.add(nature);
        listaPublicaciones.add(science);

        quijote.prestar();
        harryPotter.prestar();

        //System.out.println(contarPrestados(listaLibros));
        System.out.println(publicacionesAnterioresA(listaPublicaciones, 1980));
        System.out.println(cuentaPrestados(listaPublicaciones));
        System.out.println(cuentaRevistas(listaPublicaciones));
        imprimirPublicaciones(listaPublicaciones);
    }

}
