package servis;

import daoImpl.DaoOsnovnoSredstvo;
import domen.OsnovnoSredstvo;

public class OsnovnoSredstvoServis {
	DaoOsnovnoSredstvo	daoOsnovnoSredstvo;

	public OsnovnoSredstvoServis(DaoOsnovnoSredstvo daoOsnovnoSredstvo) {
		this.daoOsnovnoSredstvo = daoOsnovnoSredstvo;
	}
	
	public void dodajOsnovnoSredstvo(OsnovnoSredstvo os) {
		daoOsnovnoSredstvo.save(os);
	}
	
	public void izlistaj() {
		daoOsnovnoSredstvo.printAll();
	}
	
}
