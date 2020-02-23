package ui;

import java.util.Scanner;

import dao.DaoOsnovnoSredstvo;
import servis.OsnovnoSredstvoServis;
import validatori.ProveraIzbora;


public class GlavnaUI {

	public static void glavniMeni(Scanner scanner) {

		int izbor = 0;

		do {
			System.out.println("\nGLAVNI MENI");
			System.out.println("1. Administracija osnovnih sredstava");
			System.out.println("2. Administracija emisija");
			System.out.println("3. Administracija studija");
			System.out.println("4. Administracija snimanja");
			System.out.println("0. KRAJ");
			System.out.print("Vas izbor:");
			izbor = ProveraIzbora.unosBroja(scanner);

			switch (izbor) {
			
			case 1:
				OsnovnaSredstvaUI.osnovnaSredstvaMeni(scanner);
				break;
				
			case 2: 
				
				break;

			}

		} while (izbor != 0);
		
		OsnovnoSredstvoServis.getInstance().sacuvajSvePodatke();

	}

	
	public static void main(String[] args) {
		glavniMeni(new Scanner(System.in));
	}

}
