/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyequipos;

import java.util.Scanner;

/**
 *
 * @author ANA
 */
public class ProyEquipos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        //CONSTANTES
        final int N_EQUIPOS = 4;

        //final int ID = 0;
        final int PARTIDOS = 0;
        final int GOLES_MARCADOS = 1;
        final int GOLES_RECIBIDOS = 2;
        final int PUNTOS = 3;

        int[][] tabla = new int[N_EQUIPOS][4];

        final int PARTIDOS_JUGADOS = N_EQUIPOS / 2;
        final int NJORNADAS = 2;

        for (int contJornadas = 0; contJornadas < NJORNADAS; contJornadas++) {
            for (int i = 0; i < PARTIDOS_JUGADOS; i++) {

                System.out.println("Introduce el identificador del equipo local");
                int idLocal = teclado.nextInt();

                System.out.println("Introduce los goles del equipo local");
                int golesLocal = teclado.nextInt();

                System.out.println("Introduce el identificador del equipo visitante");
                int idVisitante = teclado.nextInt();

                System.out.println("Introduce los goles del equipo visitante");
                int golesVisitante = teclado.nextInt();

                tabla[idLocal - 1][PARTIDOS]++;
                tabla[idVisitante - 1][PARTIDOS]++;

                tabla[idLocal - 1][GOLES_MARCADOS] = tabla[idLocal - 1][GOLES_MARCADOS]
                        + golesLocal;
                tabla[idVisitante - 1][GOLES_MARCADOS] = tabla[idVisitante - 1][GOLES_MARCADOS]
                        + golesVisitante;

                tabla[idLocal - 1][GOLES_RECIBIDOS] = tabla[idLocal - 1][GOLES_RECIBIDOS]
                        + golesVisitante;
                tabla[idVisitante - 1][GOLES_RECIBIDOS] = tabla[idVisitante - 1][GOLES_RECIBIDOS]
                        + golesLocal;

                if (golesLocal > golesVisitante) {
                    tabla[idLocal - 1][PUNTOS] = tabla[idLocal - 1][PUNTOS] + 3;
                } else if (golesLocal < golesVisitante) {
                    tabla[idVisitante - 1][PUNTOS] = tabla[idVisitante - 1][PUNTOS] + 3;
                } else {
                    tabla[idLocal - 1][PUNTOS] = tabla[idLocal - 1][PUNTOS] + 1;
                    tabla[idVisitante - 1][PUNTOS] = tabla[idVisitante - 1][PUNTOS] + 1;
                }
            }

            imprimirTabla(tabla);

        }
    }

    //Arreglar al tabla para que quede mejor
    private static void imprimirTabla(int[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("%5d ", tabla[i][j]);
            }
            System.out.println();
        }
    }

}
