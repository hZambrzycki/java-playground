/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_hubert_zambrzycki;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dawmi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Emisora x = new Emisora_Tradicional(1, 1950, "Los 40", 93.9, 1);
        Emisora y = new Emisora_Tradicional(2, 1980, "Los 70", 120.1, 2);

        
        Emisora z = new Emisora_Online(3, 2000, "OnlineNet", "www.Online.net", 3);
        Emisora a = new Emisora_Online(4, 2005, "InternetEsYa",
                "www.internetesya.com", 4);
        
        
        Emisora j = new Emisora_Tradicional(5, 1952, "Los 50", 94.9, 5);
        Emisora k = new Emisora_Tradicional(6, 1980, "Los 10", 92.1, 6);
        ArrayList<Emisora> emisoras = new ArrayList<>();

        emisoras.add(x);
        emisoras.add(y);
        emisoras.add(z);
        emisoras.add(a);
        emisoras.add(j);
        emisoras.add(k);

        z.iniciarEmision();
        a.iniciarEmision();
        
        
        System.out.println("");
        System.out.println("");

        imprimirOnLineEmitiendo(emisoras);

        System.out.println("");
        System.out.println("");

        System.out.println("Las emisoras entre el intervalo de frecuencias 90.1-100.4. Son : ");
        calcularEmitiendoIntervaloFrecuencias(emisoras, 90.1, 100.4);

    }

    public static int calcularEmitiendoIntervaloFrecuencias(ArrayList<Emisora> emisoras, double frecuenciaIni, double frecuenciaFin) {
        int cantidadEmisoras = 0;
        for (int i = 0; i < emisoras.size(); i++) {
            if (emisoras.get(i) instanceof Emisora_Tradicional) {
                if (((Emisora_Tradicional) emisoras.get(i)).
                        getFrecuencia() > frecuenciaIni) {
                    if (((Emisora_Tradicional) emisoras.get(i)).
                            getFrecuencia() < frecuenciaFin) {
                        cantidadEmisoras++;
                    }
                }

            }

        }
        System.out.println(cantidadEmisoras);
        return cantidadEmisoras;
    }

    public static int imprimirOnLineEmitiendo(ArrayList<Emisora> emisoras) {
        int cantidadEmisores = 0;

        for (int i = 0; i < emisoras.size(); i++) {
            if (emisoras.get(i) instanceof Emisora_Online) {
                if (((Emisora_Online) emisoras.get(i)).estaEmitiendo()) {
                    System.out.println(emisoras.get(i).toString());
                }

            }
        }

        return cantidadEmisores;
    }
}
