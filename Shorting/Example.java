/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort.apuntes;

import java.util.Arrays;

/**
 *
 * @author hz
 */
public class ApuntesInternete {
      public static void main(String[] args) 
    {
        // This is unsorted array
        int[] array = new int [] { 12, 13, 24, 10, 3, 6, 90, 70 };
 
        // Let's sort using quick sort
        quickSort( array, 0, array.length - 1 );
 
        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }
 
    public static void quickSort(int[] arr, int izquierda, int derecha) 
    {
        //check for empty or null array
            
        if (arr == null || arr.length == 0){
            return;
        }
      
        if (izquierda >= derecha){
            return;
        }
 
        //Get the pivot element from the middle of the list
        int posicionPivote = izquierda + (derecha - izquierda) / 2;
        int pivote = arr[posicionPivote];
 
        // make left < pivot and right > pivot
        int izq = izquierda, der = derecha;
        while (izq <= der) 
        {
            //Check until all values on left side array are lower than pivot
            while (arr[izq] < pivote) 
            {
                izq++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[der] > pivote) 
            {
                der--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (izq <= der) 
            {
                intercambiarPosicion (arr, izq, der);
                izq++;
                der--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (izquierda < der){
            quickSort(arr, izquierda, der);
        }
        if (derecha > izq){
            quickSort(arr, izq, derecha);
        }
    }
     
    public static void intercambiarPosicion (int array[], int x, int y)
    {
        int temporal = array[x];
        array[x] = array[y];
        array[y] = temporal;
    }
}

