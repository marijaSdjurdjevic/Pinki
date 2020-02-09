package servis;

import daoImpl.DaoOsnovnoSredstvo;
import domen.OsnovnoSredstvo;
import timer.TimerUpis;

public class OsnovnoSredstvoServis {
	DaoOsnovnoSredstvo	daoOsnovnoSredstvo;

	public OsnovnoSredstvoServis(DaoOsnovnoSredstvo daoOsnovnoSredstvo) {
		this.daoOsnovnoSredstvo = daoOsnovnoSredstvo;
		TimerUpis.timerZaUpis(daoOsnovnoSredstvo);
	}
	
	public void dodajOsnovnoSredstvo(OsnovnoSredstvo os) {
		daoOsnovnoSredstvo.save(os);
	}
	
	public void izlistaj() {
		daoOsnovnoSredstvo.printAll();
	}
	
}
