package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.impl.DaoOsnovnoSredstvoImplFiles;
import domen.OsnovnoSredstvo;
import domen.Tip;
import servis.OsnovnoSredstvoServis;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		DaoOsnovnoSredstvoImplFiles daoos = new DaoOsnovnoSredstvoImplFiles();
//		Optional<OsnovnoSredstvo> os = daoos.vratiPoSifri(1);
//		OsnovnoSredstvoServis osServis = OsnovnoSredstvoServis.getInstance();
//		osServis.dodajOsnovnoSredstvo(
//				new OsnovnoSredstvo("2020-0055", "HP VB710", "HP opticka kamera 100MP", Tip.Kamera, LocalDate.of(2019, 06, 06)));
//		osServis.dodajOsnovnoSredstvo(
//				new OsnovnoSredstvo("TR-0001", "Canon s12", "Canon stativ 12cm", Tip.Stativ, LocalDate.of(2018, 06, 06)));
//		osServis.dodajOsnovnoSredstvo(
//				new OsnovnoSredstvo("2020-0002", "Maxin G55", "High volume 5000", Tip.Reflektor, LocalDate.of(2019, 02, 02)));
//		osServis.dodajOsnovnoSredstvo(
//				new OsnovnoSredstvo("TR-0002", "Canon HV-17", "Objektiv 50x zoom", Tip.Objektiv, LocalDate.of(2018, 07, 06)));
//		System.out.println(os.isPresent());
//		osServis.izlistaj();
		
//		osServis.izlistajPoNazivu();
//		osServis.izlistajPoDatumu();
//		osServis.nadjiPoNazivu("Canon VB710");
		OsnovnoSredstvoServis.getInstance().izlistajTipoveOS();
		OsnovnoSredstvoServis.getInstance().izlistajPoTipu("Objektiv");
		
		
		
	}
	
	public void asfa() {
		System.out.println();
	}
}
