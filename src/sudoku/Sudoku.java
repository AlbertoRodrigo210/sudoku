package sudoku;

import java.util.Scanner;

public class Sudoku {

	static String[][] matrizcorrecta = new String[9][9];
	static String[][] matrizsincompletar = new String[9][9];
	static final String fila= "8,7,9,6,5,3,4,1,2,1,5,6,2,7,4,8,3,9,2,4,3,8,9,1,7,6,5,7,3,8,5,1,6,2,9,4,6,9,1,7,4,2,5,8,3,4,2,5,3,8,9,6,7,1,9,5,7,1,2,8,3,4,6,1,6,2,4,3,7,9,5,8,3,8,4,9,6,5,1,2,7";
	static final String[] vector= fila.split(",");
	static final String fila2= " ,7, , ,5, ,4, ,2, , , ,2,7,4, , , ,2, , , , , ,7, , , , , , , , , , , , ,9, , ,4,2,5, ,3,4,2, ,3, ,9, , , ,9, , ,1, ,8, , , , ,6,2,4, ,7, , ,8,3, , ,9,6,5, , , ";
	static final String[] vector2= fila2.split(",");
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int fila = 0, columna = 0, numero = 0;
		String numero2 = "";
		
		llenarmatrices();
		
		mostrarsudoku();
		
		boolean seguir = true;
		boolean seguir1 = true;
		String seguirsi = "";
		
		while (seguir) {
			System.out.println("\n____________________________________________________________________________");
		System.out.println("¿Quieres hacer este sudoku o abandonarlo ya? (si quieres avanzar escribe si)");
		seguirsi = tec.nextLine().toUpperCase();
		
		if (seguirsi.equals("SI")) {
			
			seguir1 = true;
			//introducir solo números
			while (seguir1) {
				try {
					do {
					System.out.print("Introduce el número de fila que quieres cambiar: ");
					fila = tec.nextInt();
		
					} while (fila < 0 || fila > 8);
					seguir1 = false;
				} catch (java.util.InputMismatchException e) {
			
					System.err.println("\nIntroduce solo números, por favor"); 
					tec.nextLine();
																}
							}
			
			seguir1 = true;
			//introducir solo números
			while (seguir1) {
				try {
					do {
					System.out.print("Introduce el número de columna que quieres cambiar: ");
					columna = tec.nextInt();
					
					} while (columna < 0 || columna > 8);
					seguir1 = false;
				} catch (java.util.InputMismatchException e) {
			
					System.err.println("\nIntroduce solo números, por favor"); 
					tec.nextLine();
																}
							}
			
			
			if (matrizsincompletar[fila][columna].equals(" ")) {	
				seguir1 = true;
				//introducir solo números
				while (seguir1) {
					try {
						do {
						System.out.print("Introduce el número que crees que va ahí: ");
						numero = tec.nextInt();
			
						} while (numero < 1 || numero > 9);
						seguir1 = false;
					} catch (java.util.InputMismatchException e) {
				
						System.err.println("\nIntroduce solo números, por favor"); 
						tec.nextLine();
																	}
								}
				
				
				numero2 = "" + numero;
				matrizsincompletar[fila][columna] = numero2;
			} else {
				System.err.println("\nLo sentimos pero has introducido un número en un lugar que ya estaba escrito");
			}
			tec.nextLine();
			mostrarsudoku();
		} else {
			seguir = false;
		}
		}
		
		for (int i = 0; i < matrizcorrecta.length; i++) {
			for (int j = 0; j < matrizcorrecta[0].length; j++) {
				if (!matrizcorrecta[i][j].equals(matrizsincompletar[i][j])) {
					matrizsincompletar[i][j] = "X";
				}
			}
		}
		
		mostrarsudoku();
		tec.close();
	}

	private static void llenarmatrices() {
		int k = 0;
		for (int i = 0; i < matrizcorrecta.length; i++) {
			for (int j = 0; j < matrizcorrecta[0].length; j++) {
				matrizcorrecta[i][j] = vector[k];
				k++;
			}
		}
		
		System.out.println("\nEste es el Sudoku que tienes que hacer: ");
		System.out.println("---------------------------------------");
		int q = 0;
		for (int i = 0; i < matrizsincompletar.length; i++) {
			for (int j = 0; j < matrizsincompletar[0].length; j++) {
				matrizsincompletar[i][j] = vector2[q];
				q++;
			}
		}
	}
	
	private static void mostrarsudoku() {
		System.out.println("\n 0  1  2   3  4  5   6  7  8");
		System.out.println(" -  -  -   -  -  -   -  -  -");
		for (int i = 0; i < matrizsincompletar.length; i++) {
			for (int j = 0; j < matrizsincompletar[0].length; j++) {
				System.out.print("["+matrizsincompletar[i][j]+"]["+matrizsincompletar[i][j+1]+"]["+matrizsincompletar[i][j+2]+"]-");
				j = j + 2;
			}
			
			System.out.print(" "+i);
			if (i == 2 || i == 5 ) {
				System.out.println("\n -  -  -   -  -  -   -  -  -");
			} else {
			System.out.println();
			}
	}
	}

}