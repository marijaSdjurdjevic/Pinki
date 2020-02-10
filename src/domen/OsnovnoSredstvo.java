package domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Comparison;

public class OsnovnoSredstvo implements Serializable{
	public static final Comparator<OsnovnoSredstvo> CompareByName = Comparator.comparing(OsnovnoSredstvo::getNaziv);
	public static final Comparator<OsnovnoSredstvo> CompareByDate = Comparator.comparing(OsnovnoSredstvo::getDatumNabake);
	
	private static int broj = 0;
	private int id;
	private String invBroj;
	private final String naziv;
	private final String opis;
	private final Tip tip;
	private final LocalDate datumNabake;
	private final Status status;
	
	private static final Set<String> invBrojevi = new HashSet<String>();
	
	public boolean proveriInvBroj(String invBroj) {
		if(invBrojevi.stream().anyMatch((ib) -> ib.equals(invBroj))){
			System.out.println("Inventarni broj postoji!");
			return false;
		}
		return true;
	}

	public OsnovnoSredstvo(String invBroj, String naziv, String opis, Tip tip, LocalDate datumNabake) {
		this.invBroj = invBroj;
		invBrojevi.add(invBroj);
		
		this.naziv = naziv;
		this.opis = opis;
		this.tip = tip;
		this.datumNabake = datumNabake;
		this.id = ++broj;
		this.status = Status.Aktivno;
	}

	public int getId() {
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OsnovnoSredstvo) {
			OsnovnoSredstvo os = (OsnovnoSredstvo)obj;
			return Integer.compare(os.getId(), getId()) == 0 && os.invBroj.equalsIgnoreCase(invBroj);
		}
		return false;
	}

	@Override
	public String toString() {
		return "OsnovnoSredstvo[" + id + "] [invBroj=" + invBroj + ", naziv=" + naziv + ", \nopis=" + opis + ", \ntip=" + tip
				+ ", datumNabake=" + datumNabake + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
	
}
