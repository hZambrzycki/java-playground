/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3multidimensionales;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ANA
 */
public class Ejercicio3Multidimensionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        float [][] tabla = new float[12][];
        
        for (int i=0; i<tabla.length; i++) {
            tabla[i] = new float[diasMes[i]];
        }
        Random rd = new Random();
        for (int i=0; i<tabla.length; i++) {
            for (int j=0; j<tabla[i].length; j++) {
                tabla[i][j] = rd.nextInt(41)-10;
            }
        }
        
        for (int i=0; i<tabla.length; i++) {
            System.out.println(Arrays.toString(tabla[i]));
        }
        
        float sumaAño =0;
        for (int i=0; i<tabla.length; i++) {
            float sumaMes =0;
            for (int j=0; j<tabla[i].length; j++) {
                sumaMes = tabla[i][j] + sumaMes;
                sumaAño = tabla[i][j] + sumaAño;
            }
            System.out.printf("La media del mes %d es:%f \n", (i+1), sumaMes/tabla[i].length);
        }
        System.out.printf("La media del del año es: %f \n", sumaAño/365);
    }
    
}
