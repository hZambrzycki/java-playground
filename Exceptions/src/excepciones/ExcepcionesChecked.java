/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hubert
 */
public class ExcepcionesChecked {

    public static void main(String[] args) {

        Scanner entrada;

        try {
            entrada = new Scanner(new File("fichero.txt"));
        } catch (FileNotFoundException ex) {
            entrada = new Scanner(System.in);
            System.err.println("No se ha encontradpo el fichero. "
                    + "Se leer� de teclado");
        }

    }

}
