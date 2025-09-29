/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorol2;

import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class JuegoRol2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Personaje puk = new Personaje("PUK", TipoRaza.ENANO, 18, 14, 300, 300);
        Mago puk = new Mago("PUK", TipoRaza.ENANO, 12, 15, 300, 300);

        ArrayList<Personaje> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(puk);
        System.out.println(listaPersonajes);
    }

}
