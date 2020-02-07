package domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class osnovnoSredstvo implements Serializable{
	private static int id = 0;
	private String invBroj;
	private final String naziv;
	private final String opis;
	private final Tip tip;
	private final LocalDate datumNabake;
	private final Status status;
	
	private static final Set<String> invBrojevi = new HashSet<String>();
	
	public boolean unesiInvBroj(String invBroj) {
		if(invBrojevi.stream().anyMatch((ib) -> ib.equals(invBroj))){
			System.out.println("Inventarni broj postoji!");
			return false;
		}
		return true;
	}

	public osnovnoSredstvo(String invBroj, String naziv, String opis, Tip tip, LocalDate datumNabake) {
		this.invBroj = invBroj;
		invBrojevi.add(invBroj);
		
		this.naziv = naziv;
		this.opis = opis;
		this.tip = tip;
		this.datumNabake = datumNabake;
		this.id = ++id;
		this.status = Status.Aktivno;
	}

	public static int getId() {
		return id;
	}

	public String getInvBroj() {
		return invBroj;
	}

//	public void setInvBroj(String invBroj) {
//		this.invBroj = unesiInvBroj(invBroj);
//	}

	public String getNaziv() {
		return naziv;
	}

	public String getOpis() {
		return opis;
	}

	public Tip getTip() {
		return tip;
	}

	public LocalDate getDatumNabake() {
		return datumNabake;
	}

	public Status getStatus() {
		return status;
	}

	public static Set<String> getInvbrojevi() {
		return invBrojevi;
	}
	
	
	
	
	
	
	
	
	
}
