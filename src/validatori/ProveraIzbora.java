package validatori;

import java.util.Scanner;

public class ProveraIzbora {
	
	public static int unosBroja(Scanner scanner) {
			int sifra;
			
			while (true) {
//				System.out.println("Unesite broj za odabir:");
				String input = scanner.next();
				scanner.nextLine();//prazni bafer
				try {
					sifra = Integer.parseInt(input);
					break;
				} catch (NumberFormatException ne) {
					System.out.println("Niste uneli broj");
				}
			}
			return sifra;
	}
}
