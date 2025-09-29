/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorot13;

/**
 *
 * @author hz
 */
public class CifradoROT13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String mensaje = "HOLA";

        Mensaje m = new Mensaje(mensaje);

        System.out.println("Mensaje cifrado -> " + m.cifrar(13));
        System.out.println("Mensaje descifrado -> " + m.desCifrar(13));
    }
    
}
