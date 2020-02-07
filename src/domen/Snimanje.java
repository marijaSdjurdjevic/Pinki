package domen;

import java.util.Date;

public class Snimanje {

	private final Date datum;
	private final Emisija emisija;
	private final List<OsnovnaSredstva> osnovnaSredstva;
	private final Korisnik urednik;
	
	public Snimanje(Date datum, Emisija emisija, List<OsnovnaSredstva> osnovnaSredstva, Korisnik urednik) {
		super();
		this.datum = datum;
		this.emisija = emisija;
		this.osnovnaSredstva = osnovnaSredstva;
		this.urednik = urednik;
	}
	public Date getDatum() {
		return datum;
	}
	public Emisija getEmisija() {
		return emisija;
	}
	public List<OsnovnaSredstva> getOsnovnaSredstva() {
		return osnovnaSredstva;
	}
	public Korisnik getUrednik() {
		return urednik;
	}
	
	
	
}
