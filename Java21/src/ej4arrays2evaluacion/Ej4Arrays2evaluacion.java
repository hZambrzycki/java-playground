import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Ej4Arrays2evaluacion {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        // TODO code application logic here
        Random rd = new Random();
        Scanner teclado = new Scanner(System.in);
        int[] lista = new int[50];

        for (int i = 0; i < lista.length; i++) {
           
            lista[i] = rd.nextInt(50) + 1;
           
            System.out.println(lista[i]);
        }

        System.out.println("Introduzca el número a buscar: ");
        int num = teclado.nextInt();

        System.out.println("La posición es " + buscarNumero(lista, num));

        System.out.println("Introduzca el número a contar: ");
        num = teclado.nextInt();

        System.out.println("El número de veces que aparece es:  " + contarNumero(lista, num));

        System.out.println("El Mayor número aparece repetido el siguiente nº de veces:  " + contarMayor(lista));

        System.out.println("Introduzca el número a comprobar: ");
        num = teclado.nextInt();

        System.out.println("¿El número introducido aparece más veces que el número mayor? :  " + masAparicionesMayor(lista, num));

        System.out.println("La media de los valores de la lista es :  " + calcularMedia(lista));

        System.out.println("La media entre el mayor y el menor es :  " + calcularMediaMayorMenor(lista));

        int[] listaInvertida = invertirLista(lista);

        for (int i = 0; i < listaInvertida.length; i++) {
            System.out.println(listaInvertida[i]);
        }

    }

    private static int buscarNumero(int[] lista, int num) {
        //recorrer el numero desde el final, poca eficiencia
        int aux = -1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == num) {
                aux = i;
            }
        }
        return aux;
    }

    private static int contarNumero(int[] lista, int num) {
        int cont = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == num) {
                cont++;
            }
        }
        return cont;
    }

    private static int contarMayor(int[] lista) {


        int aux = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > aux) {
                aux = lista[i];
            }
        }
    
        int cont = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == aux) {
                cont++;
            }
        }

        return cont;
    }

    private static boolean masAparicionesMayor(int[] lista, int num) {
        boolean masApariciones = false;
       
        //no hace falta repetir el codigo, ya que lo hago en el método de antes
        int aux = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > aux) {
                aux = lista[i];
            }
        }
       
        int contMayor = 0;
        int contNum = 0;
        for (int i = 0; i < lista.length; i++) {
          
            if (lista[i] == aux) {
                contMayor++;
            }
         
            if (lista[i] == num) {
                contNum++;
            }
        }

      
        if (contNum > contMayor) {
            masApariciones = true;
        }

        return masApariciones;
    }

    private static double calcularMedia(int[] lista) {
        double media = 0;

        for (int i = 0; i < lista.length; i++) {
            media += lista[i];
        }

        return media / lista.length;
    }

    private static double calcularMediaMayorMenor(int[] lista) {
       
        int auxMayor = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > auxMayor) {
                auxMayor = lista[i];
            }
        }

     
        int auxMenor = 51;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] < auxMenor) {
                auxMenor = lista[i];
            }
        }

        double mediaMayorMenor = (auxMayor + auxMenor) / 2;

        return mediaMayorMenor;
    }

    private static int[] invertirLista(int[] lista) {

        int contAux = lista.length - 1;
        int[] listaAux = new int[50];

        for (int i = 0; i < lista.length; i++) {
            listaAux[contAux--] = lista[i];
        }

        return listaAux;
    }
    //private static void impimirLista(int [] lista) {
    // for int i =0 i<lista.length-1; i ++ {
    // sout lista i
    //

}
