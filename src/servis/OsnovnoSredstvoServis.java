package servis;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
	
	public void izlistajPoNazivu() {
		daoOsnovnoSredstvo.getAllByPredicate(OsnovnoSredstvo.CompareByName).stream().forEach(System.out::println);
	}
	
	public void izlistajPoDatumu() {
		daoOsnovnoSredstvo.getAllByPredicate(OsnovnoSredstvo.CompareByDate).stream().forEach(System.out::println);
	}
	
	public void izlistajTipoveOS() {
		daoOsnovnoSredstvo.izlistajTipoveOS();
	}
	
	public void izlistajPoTipu(String tip) {
		List<OsnovnoSredstvo> lista = daoOsnovnoSredstvo.getByTip(tip);
		if(lista == null || lista.isEmpty())
			System.out.println("Nije nadjeno osnovno sredstvo po zadatom tipu.");
		else
			lista.forEach(System.out::println);
	}
	
	public void izlistaj() {
		daoOsnovnoSredstvo.printAll();
	}
	
	public void nadjiPoNazivu(String naziv) {
		List<OsnovnoSredstvo> lista = daoOsnovnoSredstvo.getByNaziv(naziv);
		if(lista == null || lista.isEmpty())
			System.out.println("Nije nadjeno osnovno sredstvo po zadatom parametru.");
		else
			lista.forEach(System.out::println);
	}
	
}
