package domen;

public class Korisnik {

	private static int counter = 0;
	private int id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String sifra;
	private Uloga uloga;

	public Korisnik() {
		super();
	}

	public Korisnik(String ime, String prezime, String korisnickoIme, String sifra, Uloga uloga) {
		super();
		counter++;
		this.id = counter;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.uloga = uloga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Korisnik: " + ime + prezime + ", korisnickoIme=" + korisnickoIme + " , sifra=" + sifra + ", uloga="
				+ uloga;
	}

}
