package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import domen.Korisnik;

public class DaoKorisnik {
	List<Korisnik> korisnici;
	int brojKorisnika;
	private String path = "";

	public DaoKorisnik() {
		korisnici = new ArrayList<>();
		upisKorisnikaUFajl();
	}
	
	private DaoKorisnik(String path) {
		super();
		this.path = path;
	}
	
	//
	@SuppressWarnings("unchecked")
	private void upisKorisnikaUFajl() {
		try (ObjectInputStream is = new ObjectInputStream(
				new FileInputStream(System.getProperty("korisnici.dir") + "podaci/korisnici.dat"))) {
			this.korisnici = (List<Korisnik>) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void sacuvajSveKorisnike() {
		try {
			FileOutputStream fos = new FileOutputStream(new File(path));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Iterator it = this.korisnici.iterator();
		while(it.hasNext()) {
			Korisnik k = (Korisnik) it.next();
			printWriter.println(k.getId());
			printWriter.println(k.getSifra());
			printWriter.println(k.getIme());
			printWriter.println(k.getPrezime());
			printWriter.println(k.getUloga());
			printWriter.flush();
		}
		
	}
		


	// dodaj(unesi) korisnika
	public void dodajKorisnika(Korisnik k) {
		korisnici.add(k);
	}

	// prikaz 1 korisnika
	public Korisnik prikaziKorisnika(int id) throws Exception {
		for (Korisnik korisnik2 : korisnici) {
			if (korisnik2.getId() == id) {
				return korisnik2;
			}
		}
		throw new Exception("Ne postoji korisnik sa unetom sifrom!");
	}

	// prikaz svih korisnika
	public void prikaziSveKorisnike() {
		for (Korisnik korisnik2 : korisnici) {
			System.out.println(korisnik2);
		}
	}

	// da lipostoji korisnik?
	public boolean daLiPostojiKorisnik(int id) {
		for (Korisnik k : korisnici) {
			if (id == k.getId())
				return true;
		}
		return false;
	}

}
