package domen;

public class Korisnik {
	
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String sifra;
	private Uloga uloga;
	
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public Korisnik(String ime, String prezime, String korisnickoIme, String sifra, Uloga uloga) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.uloga = uloga;
	}
	
	@Override
	public String toString() {
		return "Korisnik: " + ime + prezime + ", korisnickoIme=" + korisnickoIme + " , sifra=" + sifra
				+ ", uloga=" + uloga;
	}
	
}



