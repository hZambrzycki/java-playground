/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysMultidimensionales;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Ej_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random rd = new Random();
        int negro = 0;
        int blanco = 0;
        System.out.println("Introduzca los valores de la trabla");
        int[][] tabla = new int[teclado.nextInt()][teclado.nextInt()];
        System.out.println("Introduzca valores dentro de la tabla");
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = teclado.nextInt();
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if(tabla[i][j] == 0) {
                   tabla.toString().replaceAll("0", "*");
                   negro++;
                } 
                if(tabla[i][j] == 255) {
                    tabla.toString().replaceAll("255"," ");
                    blanco++;
                }
                
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.println(tabla[i][j]);
            }
        }
        
        System.out.println("El total de pixeles negros es : " + negro);
        System.out.println("El total de pixeles en blanco es: " + blanco);

    }

}
