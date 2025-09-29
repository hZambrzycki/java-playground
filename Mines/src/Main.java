import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int num1;
	static int num2;

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String linea;
		char[][] tablero = null;

		while (true) {

			num1 = teclado.nextInt();
			num2 = teclado.nextInt();

			if (num1 == 0 || num2 == 0) {
				System.exit(0);
			}
			teclado.nextLine();
			tablero = new char[num2][num1];

			for (int i = 0; i < num2; i++) {
				linea = teclado.nextLine();
				for (int j = 0; j < num1; j++) {
					tablero[i][j] = linea.charAt(j);
				}
			}

			calcularEspaciosMinas(tablero);

		}
	}

	private static boolean noSeSaleDelTablero(int i, int j) {
		if (i >= 0 && i < num2 && j >= 0 && j < num1) {
			return true;
		}
		return false;
	}

	private static void calcularEspaciosMinas(char[][] tablero) {

//		for (int i = 0; i < tablero.length; i++) {
//	            System.out.println(Arrays.toString(tablero[i]));
//	        }

		int espaciosConMasDe6Minas = 0;
		int minasAlrededor = 0;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == '-') {
					minasAlrededor = buscarMinas(tablero, i, j);
					if (minasAlrededor >= 6) {
						espaciosConMasDe6Minas++;
					}
				}
			}
		}

		System.out.println(espaciosConMasDe6Minas);

	}

	private static int buscarMinas(char[][] tablero, int i, int j) {

		int minas = 0;
		int auxFila=0;
		int auxColumna=0;
		int [] posF = {1,-1,0,0,1,-1,-1,1};
		int [] posC = {0,0,1,-1,1,-1,1,-1};
		
		for (int k = 0; k < 8; k++) {
			
			auxFila= i+posF[k];
			auxColumna= j+posC[k];
			
			if(noSeSaleDelTablero(auxFila,auxColumna) && tablero[auxFila][auxColumna]=='*') {
				minas++;
			}
		}
		return minas;
	}

}
