package dao;

import java.util.ArrayList;
import java.util.List;

import domen.Korisnik;
import domen.Uloga;


public class DaoKorisnik {
	List<Korisnik> korisnik;
	int brojKorisnika;
	
	
	public DaoKorisnik() {
		korisnik = new ArrayList<>();{
			
		{
			korisnik.add(new Korisnik("Marko", "Markovic", "markoMarkovic", "!marko@", Uloga.ADMIN));
			korisnik.add(new Korisnik("Petar", "Petrovic", "petarPetrovic", "@petar!", Uloga.ADMIN));
			korisnik.add(new Korisnik("Ana", "Anic", "anaAnic", "!marko@", Uloga.EDITOR));
			korisnik.add(new Korisnik("Marija", "Maric", "marijaMaric", "Mmarija123", Uloga.EDITOR));
			korisnik.add(new Korisnik("Milica", "Milic", "milicaMilic", "cicamica987", Uloga.EDITOR));
			korisnik.add(new Korisnik("Zika", "Zivkovic", "ZikaZIvac", "CuvajSeUjedam!", Uloga.EDITOR));
			korisnik.add(new Korisnik("Djordje", "Djordjevic", "DjordjeDjoka", "NisamKreativna", Uloga.EDITOR));
		}
	};
	
	
}

	public List<Korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(List<Korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public int getBrojKorisnika() {
		return brojKorisnika;
	}

	public void setBrojKorisnika(int brojKorisnika) {
		this.brojKorisnika = brojKorisnika;
	}
	
	//dodaj(unesi) korisnika
	public void dodajKorisnika(Korisnik k) {
		korisnik.add(k);
	}
	
	//prikaz 1 korisnika
	public Korisnik prikaziKorisnika(int id) throws Exception{
		for (Korisnik korisnik2 : korisnik) {
			if (korisnik2.getId() == id) {
				return korisnik2;
			}
		}throw new Exception("Ne postoji korisnik sa unetom sifrom!");
	}
	
	//prikaz svih korisnika
	public void prikaziSveKorisnike() {
		for (Korisnik korisnik2 : korisnik) {
			System.out.println(korisnik2);
		}
	}
	
	//da lipostoji korisnik?
	public boolean daLiPostojiKorisnik(int id) {
		for (Korisnik k : korisnik) {
			if (id == k.getId())return true;
		} 
		return false;
	}
	
}
