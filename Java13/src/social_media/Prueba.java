/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_recuperacion_hubert_zambrzycki;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    
      
    Usuario Lucas = new Usuario(1, "Juan", "Gomez Gonzalez");
     
    Usuario Luis = new Usuario(2, "Luis", "Lopez Lopez");
      
    Usuario Pedro = new Usuario(3, "Pedro", "Carlos Dominguez");
     ;
    Usuario Juan = new Usuario(4, "Juan", "Sanchez Sanchez");
    
    
    Red_Social twitter = new Red_Social(teclado.nextInt());
    
        System.out.println(twitter.agregarUsuario(teclado.next(), teclado.next()));
        System.out.println(twitter.agregarUsuario(teclado.next(), teclado.next()));
        System.out.println(twitter.agregarUsuario(teclado.next(), teclado.next()));
        System.out.println(twitter.agregarUsuario(teclado.next(), teclado.next()));
        System.out.println(twitter.toString());
        
        System.out.println(twitter.buscarUsuario("Sanchez"));
        
        System.out.println(twitter.buscarUsuario("Gomez"));
            
            
    }
    
}
