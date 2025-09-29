/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hubert
 */
public class ExcepcionesUnChecked {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        int valor;
        try {
            valor = teclado.nextInt();
        }
        catch (InputMismatchException e) {
            valor=0;
            System.err.println("Error. El valor debe ser un entero. "
                    + "Se asigna el valor 0 por defecto");
        }
        
        
        System.out.println(valor*2);
        
        
        
    }
    
}
