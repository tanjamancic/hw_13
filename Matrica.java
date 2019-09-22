package domaci0812i0813;

import java.util.Random;
import java.util.Scanner;

public class Matrica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite dimenziju kvadratne matrice (n): ");
		int n = sc.nextInt();

		int[][] matrica = new int[n][n];
		generisiElementeMatrice(matrica,100);
		System.out.println("Matrica izgleda ovako: ");
		ispisiMatricu(matrica);
		System.out.println();

		int[] elementiNaglavnoj = elementiNaGlavnojDijagonali(matrica);
		System.out.println("Elementi na glavnoj dijagonali su: ");
		if (elementiNaglavnoj != null)
			ispisiNiz(elementiNaglavnoj);
		else
			System.out.println("Greska u funkciji elementiNaGlavnojDijagonali");
		System.out.println();

		System.out.println("Elementi na sporednoj dijagonali su: ");
		int[] elementiNaSporednoj = elementiNaSporednojDijagonali(matrica);
		if (elementiNaSporednoj != null)
			ispisiNiz(elementiNaSporednoj);
		else
			System.out.println("Greska u funkciji elementiNaSporednojDijagonali");
		System.out.println();

		System.out.println("Elementi iznad glavne dijagonale su: ");
		ispisiElementeIznadGlavneDijagonale(matrica);
		System.out.println();

		System.out.println("Elementi ispod glavne dijagonale su: ");
		ispisiElementeIspodGlavneDijagonale(matrica);
		System.out.println();

		int[][] transponovanaMatrica = transponujMatricu(matrica);
		System.out.println("Transponovana matrica izgleda ovako: ");
		if (transponovanaMatrica != null)
			ispisiMatricu(transponovanaMatrica);
		else
			System.out.println("Greska u funkciji transponujMatricu.");
		System.out.println();

		System.out.println("Pre uklanjanja duplih elemenata niz izgleda ovako: ");
		ispisiNiz(elementiNaglavnoj);
		System.out.println();

		elementiNaglavnoj = ukloniElementeKojiSePonavljajuUnizu(elementiNaglavnoj);
		System.out.println("Nakon uklanjanja duplih elemenata niz izlgeda ovako: ");
		if (elementiNaglavnoj != null)
			ispisiNiz(elementiNaglavnoj);
		else
			System.out.println("Greska u funkcji ukloniElementeKojiSePonavljajuUnizu");

	}

	public static void generisiElementeMatrice(int[][] matrica, int gornjaGranica) {
		Random r = new Random();
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = r.nextInt(gornjaGranica);
			}
		}
	}

	public static int[] elementiNaGlavnojDijagonali(int[][] matrica) {
		int[] glavnaDijagonala = new int[matrica.length];
		for (int i = 0; i < matrica.length; i++) {
			glavnaDijagonala[i] = matrica[i][i]; // moze zato sto je kvadratna matrica
		}

		return glavnaDijagonala;
	}

	public static int[] elementiNaSporednojDijagonali(int[][] matrica) {
		int[] sporednaDijagonala = new int[matrica.length];
		for (int i = 0; i < matrica.length; i++) {
			sporednaDijagonala[i] = matrica[i][matrica.length - 1 - i];
		}

		return sporednaDijagonala;
	}

	public static int[][] transponujMatricu(int[][] matrica) {
		int[][] transponovana = new int[matrica[0].length][matrica.length];
		for (int i = 0; i < matrica[0].length; i++) {
			for (int j = 0; j < matrica.length; j++) {
				transponovana[j][i] = matrica[i][j];
			}
		}
		return transponovana;
	}

	public static void ispisiElementeIznadGlavneDijagonale(int[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = i + 1; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void ispisiElementeIspodGlavneDijagonale(int[][] matrica) {
		for (int i = 1; i < matrica.length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void ispisiMatricu(int[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void ispisiNiz(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
	}

	public static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz) {
		int ponavljanje = 0;
		for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] == niz[j]) {
					ponavljanje++;
					break;
				}
			}
		}
		int[] nizBezPonavljanja = new int[niz.length - ponavljanje];
		int k = 1;
		nizBezPonavljanja[0] = niz[0];
		for (int i = 1; i < niz.length; i++) {
			boolean unique = true;
			for (int j = 0; j < i; j++) {
				if (niz[i] == niz[j]) {
					unique = false;
				}
			}
			if (unique) {
				nizBezPonavljanja[k] = niz[i];
				k++;
			}
		}
		return nizBezPonavljanja;
	}

}
