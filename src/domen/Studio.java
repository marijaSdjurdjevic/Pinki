package domen;

public class Studio {

	private int id;
	private String naziv;
	private String opis;
	private String lokacija;
	
	private Studio(int id, String naziv, String opis, String lokacija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.lokacija = lokacija;
	}

	
	
	private Studio(String naziv, String opis, String lokacija) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.lokacija = lokacija;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}



	@Override
	public String toString() {
		return "Studio [id=" + id + ", " + (naziv != null ? "naziv=" + naziv + ", " : "")
				+ (opis != null ? "opis=" + opis + ", " : "") + (lokacija != null ? "lokacija=" + lokacija : "") + "]";
	}
	
	
	
	
}
