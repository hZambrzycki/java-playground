/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsahorcado;

import java.util.Scanner;

/**
 *
 * @author hz
 */
public class StringsAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        String palabraOculta = "";
        System.out.println("Bienvenido al ahorcado, introduzca el texto a adivinar");
        
        String texto = teclado.nextLine();
        
        char [] letras = texto.toCharArray();
        
        final int numeroIntentos = letras.length+7;
        
        char [] letrasOcultas = new char[letras.length];
        
        for (int i = 0; i < letrasOcultas.length; i++) {
            letrasOcultas[i]= '_';
        }
        
        System.out.println("Comenzando el juego \n");
        
        jugar(texto,letrasOcultas, letras, numeroIntentos);
       
    }

    private static void jugar(String texto, char[] letrasOcultas, char[] letras, int numeroIntentos) {
      Scanner teclado = new Scanner(System.in);
      
      boolean palabraAdivinada = false;
      
      while(numeroIntentos > 0 && !palabraAdivinada) {
          String palabra = "";
          
          System.out.println("Introduce una letra");
          
          char letraIntroducida = teclado.next().charAt(0);
          
          for (int i = 0; i < letras.length; i++) {
              if(letras[i] == letraIntroducida) {
                  letrasOcultas[i]= letraIntroducida;
              }
              palabra += letrasOcultas[i];
          }
          System.out.println("\n*********************************************");
            System.out.println("\nEstado de la palabra --> " + palabra);
            System.out.println("\nIntentos restantes --> " + --numeroIntentos + "\n");
            System.out.println("*********************************************\n");
            
            int cont = 0;
            for (int i = 0; i < letrasOcultas.length; i++) {
              if(letrasOcultas[i] == '_') {
                  cont++;
              }
          }
            if (cont==0) {
                palabraAdivinada= true;
                System.out.println("Enhorabuena blablabla");
            }
      }
      if(palabraAdivinada = false) {
          System.out.println("Has perdido");
      }
    }
    
}
