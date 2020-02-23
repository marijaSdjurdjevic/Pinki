package servis;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import dao.DaoOsnovnoSredstvo;
import dao.impl.DaoOsnovnoSredstvoImplFiles;
import domen.OsnovnoSredstvo;
import exceptions.DataAlreadyPresent;
import exceptions.DataNotPresent;
import exceptions.ValidationException;
import timer.TimerUpis;

public class OsnovnoSredstvoServis {
	DaoOsnovnoSredstvo daoOsnovnoSredstvo;

	private OsnovnoSredstvoServis() {
		try {
			this.daoOsnovnoSredstvo = new DaoOsnovnoSredstvoImplFiles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TimerUpis.timerZaUpis(daoOsnovnoSredstvo);
	}
	
	private static OsnovnoSredstvoServis instance;
	
	public static OsnovnoSredstvoServis getInstance() {
		if(instance == null) {
			instance = new OsnovnoSredstvoServis();
			return instance;
		}
		return instance;
	}
	
	public void dodajOsnovnoSredstvo(OsnovnoSredstvo os) {
		daoOsnovnoSredstvo.save(os);
	}
	
	public void izlistajPoNazivu() {
		daoOsnovnoSredstvo.vratiPoUslovu(OsnovnoSredstvo.CompareByName).stream().forEach(System.out::println);
	}
	
		
	public void izlistajPoDatumu() {
		daoOsnovnoSredstvo.vratiPoUslovu(OsnovnoSredstvo.CompareByDate).stream().forEach(System.out::println);
	}
	
	public void izlistajTipoveOS() {
		daoOsnovnoSredstvo.izlistajTipoveOS();
	}
	
	public Optional<OsnovnoSredstvo> proveriInvBroj(String invBroj) throws DataAlreadyPresent {
		return daoOsnovnoSredstvo.vratiPoInventarnomBroju(invBroj);
	}
	
	public void izlistajPoTipu(String tip) {
		List<OsnovnoSredstvo> lista;
		try {
			lista = daoOsnovnoSredstvo.vratiPoTipu(tip);
			if(lista.isEmpty())
				throw new DataNotPresent("Nije nadjeno osnovno sredstvo po zadatom tipu.");
			else
				lista.forEach(System.out::println);
		} catch (DataNotPresent | ValidationException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean proveriTip(String tip) {
		try {
			daoOsnovnoSredstvo.proveraTipa(tip);
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void izlistaj() {
		try {
			daoOsnovnoSredstvo.printAll();
		} catch (DataNotPresent e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public void sacuvajSvePodatke() {
		try {
			daoOsnovnoSredstvo.upisiPodatke();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nadjiPoNazivu(String naziv) {
		List<OsnovnoSredstvo> lista = daoOsnovnoSredstvo.vratiPoNazivu(naziv);
		if(lista == null || lista.isEmpty())
			System.out.println("Nije nadjeno osnovno sredstvo po zadatom parametru.");
		else
			lista.forEach(System.out::println);
	}
	
}
