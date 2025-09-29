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
public class QuicksortApuntes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*
        Pillar la primera posicion de un array {8,3,6,4,2,5,7,1}
        Para hacer esto:
        
        Crear variable int izq, int derecha:
        La longitud del array es 0-7
        int izquierda :  Pillamos la primera posicion: (8)
        int derecha : la ultima posicion (1)
        
        int pivote: la formula para pillar la mitad siendo par o impar....
        
        izq < pivote?
        Mas pequeño?
        Si es si, pasamos al siguiente
        3 es mas pequeño que el 2?
        No, 3 se convierte al pivote y comparamos por el otro lado
        8 derecha> es mayor que el pivote?
        Si, saltamos el pivote al 5
        Es el 5 mayor que el pivote? Si, saltamos again
        6,4 igual
        Cuando llegamos al dos valoramos si son estrictamente mayores, cosa que no pasa, por lo cual lo bajamos y el 3,2 intercambian posicion
        */
    
        int [] array = {8,3,2,1,5,4,6,7};
        
        int izquierda;
        int derecha;
        
        int pivote;
        
   

    }
    
    
}
