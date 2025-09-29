/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Numeros {
     Random rd = new Random();
    
    
     
     private int lim1 = rd.nextInt(10);
     
     private int lim2 = rd.nextInt(99);

    public int getLim1() {
        return lim1;
    }

    public int getLim2() {
        return lim2;
    }
     
    
   
}
 

