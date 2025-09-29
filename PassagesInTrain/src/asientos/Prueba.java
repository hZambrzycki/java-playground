/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asientos;

/**
 *
 * @author Hubert Zambrzycki
 */
public class Prueba {
    public static void main(String[] args) {
        Pasajero p = new Pasajero("8121828121", "Domingo", "Pedrosa");
        Pasajero p2 = new Pasajero("dni1", "Jaime", "Gutierrez");
        Pasajero p3 = new Pasajero("dni2", "Manuel", "Ozuna");
        Tren chuchu = new Tren(10);
        System.out.println("Reservamos asiento 23 para p2");
        casosReserva(chuchu.reservarAsiento(p2.getDni(), 23));
        System.out.println("Reservamos asiento 1 para p2");
        casosReserva(chuchu.reservarAsiento(p2.getDni(), 1));
        System.out.println("Reservamos asiento 1 para p3");
        casosReserva(chuchu.reservarAsiento(p3.getDni(), 1));
        System.out.println("Reservamos asiento 5 para p3");
        casosReserva(chuchu.reservarAsiento(p3.getDni(), 5));
        boolean aux = false;
        System.out.println("Anulamos reserva para p2");
        aux = chuchu.anularReserva(p2.getDni());
        if(aux) {
            System.out.println("Reserva anulada");
        }else {
            System.out.println("No existe la reserva");
        }
        System.out.println("Anulamos reserva para p");
        aux=chuchu.anularReserva(p.getDni());
        if(aux) {
            System.out.println("Reserva anulada");
        }else {
            System.out.println("No existe la reserva");
        }
    }

public static void casosReserva(int aux) {
        switch (aux) {
        case -1: {
            System.out.println("No existe ese asiento");
            break;
        }
        case 1: {
            System.out.println("Asiento reservado");
            break;
        }
        case 2: {
            System.out.println("Asiento no disponible,ya está reservado por otro pasajero");
            break;
        }
        case 3: {
            System.out.println("Reserva no válida.Cada pasajero solo tiene derecho a un asiento.");
            break;
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + aux);
        }
    }
}