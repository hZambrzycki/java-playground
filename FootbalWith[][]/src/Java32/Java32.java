/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciorecuperacionhubertzambrzycki;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class EjercicioRecuperacionHubertZambrzycki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);

		int numero;

		boolean continuar = true;
			
		boolean continuar2 = true;
		
		while (continuar2) {
		
			ArrayList<Integer> numeros = new ArrayList<Integer>();
			
			continuar = true;
			
			while (continuar) {
				numero = teclado.nextInt();
				
				numeros.add(numero);
				
				if (numero == 0) {
					continuar = false;
				}
			}
			if (numeros.size() == 1 && numeros.get(0) == 0) {
				continuar2 = false;
			} else {
				evaluar(numeros);
				System.out.println("");
			}
		}
	}

	public static void evaluar(ArrayList<Integer> numeros) {
		
		boolean vanSeguidos = false;
		
		int numero = numeros.get(0);
		int numero2;
		int aux = numero;

		for (int i = 1; i < numeros.size(); i++) {
			numero2 = numeros.get(i);
			if (aux == numero2 - 1) {
				vanSeguidos = true;

			} 
			else {
				if (vanSeguidos) {
					System.out.print(numero + "-" + aux);
					numero = numero2;
					vanSeguidos = false;
					if (numero2 != 0)
						System.out.print(",");
				} else {
					System.out.print(aux);
					numero = numero2;
					if (numero2 != 0)
						System.out.print(",");
				}
			}
			aux = numero2;
		}
	}
}

    
    

