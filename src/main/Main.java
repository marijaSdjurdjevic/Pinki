package main;

import java.time.LocalDate;

import daoImpl.DaoOsnovnoSredstvo;
import domen.OsnovnoSredstvo;
import domen.Tip;
import servis.OsnovnoSredstvoServis;

public class Main {

	public static void main(String[] args) throws Exception {
		OsnovnoSredstvoServis osServis = new OsnovnoSredstvoServis(new DaoOsnovnoSredstvo());
		osServis.dodajOsnovnoSredstvo(
				new OsnovnoSredstvo("2020-0001", "Canon VB710", "Canon opticka kamera 50MP", Tip.Kamera, LocalDate.of(2018, 06, 06)));
		osServis.dodajOsnovnoSredstvo(
				new OsnovnoSredstvo("TR-0001", "Canon s12", "Canon stativ 12cm", Tip.Stativ, LocalDate.of(2018, 06, 06)));
		osServis.dodajOsnovnoSredstvo(
				new OsnovnoSredstvo("2020-0002", "Maxin G55", "High volume 5000", Tip.Reflektor, LocalDate.of(2019, 02, 02)));
		osServis.dodajOsnovnoSredstvo(
				new OsnovnoSredstvo("TR-0002", "Canon HV-17", "Objektiv 50x zoom", Tip.Objektiv, LocalDate.of(2018, 07, 06)));
		
		osServis.izlistaj();
		
//		DaoOsnovnoSredstvo daoOS = new DaoOsnovnoSredstvo();
//		daoOS.save(new OsnovnoSredstvo("2020-0001", "Canon VB710", "Canon opticka kamera 50MP", Tip.Kamera, LocalDate.of(2018, 06, 06)));
//		daoOS.printAll();
		
	}
	
	public void asfa() {
		System.out.println();
	}
}
