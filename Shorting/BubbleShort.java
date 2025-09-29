/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort.apuntes;

/**
 *
 * @author hz
 */
public class BurbujaApuntes {
    public static void main(String[] args) {
        int [] array = {2,3,6,7,5,1,8,4};
        burbuja(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    public static void burbuja(int[] array) {
        int i, j, aux;
        
        for (i = 0; i < array.length - 1; i++) {
            
            for (j = 0; j < array.length - i - 1; j++) {
                
                if (array[j + 1] < array[j]) {
                    
                    aux = array[j + 1];
                    
                    array[j + 1] = array[j];
                    
                    array[j] = aux;
                }
            }
        }
}
}
