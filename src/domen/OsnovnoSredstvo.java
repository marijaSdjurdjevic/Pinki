package domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.xpath.internal.operations.Equals;
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof OsnovnoSredstvo)) return false;
		OsnovnoSredstvo os = (OsnovnoSredstvo)obj;
		return Integer.compare(os.getId(), getId()) == 0 && os.invBroj.equalsIgnoreCase(invBroj);
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
			builder.append("OsnovnoSredstvo[");
			builder.append(id);
			builder.append("] [invBroj=");
			builder.append(invBroj);
			builder.append(", naziv=");
			builder.append(naziv);
			builder.append(", \nopis=");
			builder.append(opis);
			builder.append(", \ntip=");
			builder.append(tip);
			builder.append(", datumNabake=");
			builder.append(datumNabake);
			builder.append(", status=");
			builder.append(status);
			builder.append("]");
		return builder.toString();
		
//		return "OsnovnoSredstvo[" + id + "] [invBroj=" + invBroj + ", naziv=" + naziv + ", \nopis=" + opis + ", \ntip=" + tip
//				+ ", datumNabake=" + datumNabake + ", status=" + status + "]";
		
	}
	
	
	
	
	
	
	
	
	
}
