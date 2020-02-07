package domen;
import java.io.Serializable;
import enums.EnumTipSnimanja;

public class Emisija implements Serializable{

	private static int counter = 0;
	private int id;
	private String naziv;
	private String opis;
	private EnumTipSnimanja tip;
	
	public Emisija(String naziv, String opis, EnumTipSnimanja tip) {
		super();
		this.id = ++counter;
		this.naziv = naziv;
		this.opis = opis;
		this.tip = tip;
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

	public Enum getTip() {
		return tip;
	}

	public void setTip(EnumTipSnimanja tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "AdministracijaEmisija [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", tip=" + tip + "]";
	}
	
	
	
}
