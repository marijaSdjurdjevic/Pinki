package ui;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import dao.DaoOsnovnoSredstvo;
import exceptions.DataAlreadyPresent;
import servis.OsnovnoSredstvoServis;
import validatori.ProveraIzbora;

public class OsnovnaSredstvaUI {

	public static Scanner scanner;
	
	public static void osnovnaSredstvaMeni(Scanner sc) {
		scanner = sc;
		
		int izbor = 0;

		do {
			System.out.println("\n\nOSNOVNA SREDSTVA - MENI");
			System.out.println("1. UNOS");
			System.out.println("2. PRIKAZ SVIH OSNOVNIH SREDSTAVA");
			System.out.println("3. PRIKAZ OSNOVNOG SREDSTVA");
			System.out.println("4. IZMENA OSNOVNOG SREDSTVA");
			System.out.println("5. BRISANJE OSNOVNOG SREDSTVA");
			System.out.println("0. KRAJ");
			System.out.print("Vas izbor:");
			izbor = ProveraIzbora.unosBroja(scanner);

			switch (izbor) {
			
			case 1:
				unosOsnovnogSredstva();
				break;
				
			case 2: 
				OsnovnoSredstvoServis.getInstance().izlistaj();
				System.out.println("Pritisnite enter za nastavak...");
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			}

		} while (izbor != 0);
		
	}

	private static void unosOsnovnogSredstva() {
		System.out.println("UNOS OSNOVNOG SREDSTVA");
		String invBroj;
			while(true) {
				System.out.println("Unesite inventarni broj");
				invBroj = scanner.next();
				try {
					if(!OsnovnoSredstvoServis.getInstance().proveriInvBroj(invBroj).isPresent())
						break;
				} catch (DataAlreadyPresent e) {
					System.out.println(e.getMessage());
				}
			}
		
		System.out.println("Unesite naziv osnovnog sredstva:");	
		String naziv = scanner.next();
		scanner.nextLine();
		System.out.println("Unesite opis osnovnog sredstva:");	
		String opis = scanner.next();
		scanner.nextLine();
		OsnovnoSredstvoServis.getInstance().izlistajTipoveOS();
		
		while(true) {
			System.out.println("Unesite tip osnovnog sredstva sa prethodne liste:");
			String tip = scanner.next();
			if(OsnovnoSredstvoServis.getInstance().proveriTip(tip))
				break;
		}
		
		
		
	}

		
}
