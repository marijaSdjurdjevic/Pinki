package dao.impl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dao.Dao;
import dao.DaoOsnovnoSredstvo;
import domen.OsnovnoSredstvo;
import domen.Tip;
import exceptions.DataNotPresent;
import exceptions.ValidationException;
import utility.SaveLoad;

public class DaoOsnovnoSredstvoImplFiles implements DaoOsnovnoSredstvo {
	private List<OsnovnoSredstvo> listaOS;
	private final File os = new File("OsnovnaSredstva.dat");

	public DaoOsnovnoSredstvoImplFiles() throws Exception {
		listaOS = new ArrayList<OsnovnoSredstvo>();
		if (!os.exists())
			os.createNewFile();
		else {
			try {
				ucitajPodatke();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}
	}

	@Override
	public Optional<OsnovnoSredstvo> vratiPoSifri(int sifra) {
		return listaOS.stream().filter((os) -> Integer.compare(os.getId(), sifra) == 0).findFirst();
	}

	public Optional<OsnovnoSredstvo> vratiPoInventarnomBroju(String invBroj) {
		return listaOS.stream().filter((os) -> os.getInvBroj().equalsIgnoreCase(invBroj)).findFirst();
	}

	public List<OsnovnoSredstvo> vratiPoNazivu(String naziv) {
		return listaOS.stream().filter((s) -> s.getNaziv().equalsIgnoreCase(naziv)).collect(Collectors.toList());
	}
	
	public List<OsnovnoSredstvo> vratiPoTipu(String tip) throws DataNotPresent, ValidationException {
		proveraTipa(tip);
		return listaOS.stream().filter((s) -> s.getTip().toString().equalsIgnoreCase(tip)).collect(Collectors.toList());
	}

	public void proveraTipa(String tip) throws ValidationException {
		Arrays.stream(Tip.values())
        .filter(e -> e.toString().equalsIgnoreCase(tip))
        .findFirst()
        .orElseThrow(() -> new ValidationException("Niste uneli ispravan tip"));
	}
	
	public void izlistajTipoveOS() {
		Arrays.asList(Tip.values()).stream().forEach(System.out::println);
	}

	public void ucitajPodatke() throws Exception {
		// mozda ovo da uradimo preko optionala?
		listaOS = SaveLoad.readObjectsFromFile(os.getName());

	}

	@Override
	public void upisiPodatke() throws IOException {
		SaveLoad.writeObjectsToFile(os, listaOS);

	}
	//Bolje da je Predicate genericki
	@Override
	public Collection<OsnovnoSredstvo> vratiPoUslovu(Comparator<OsnovnoSredstvo> comparator) {
		Collections.sort(listaOS, comparator);
		return listaOS;
	}

	@Override
	public int save(OsnovnoSredstvo t) {
		if (t != null && !vratiPoInventarnomBroju(t.getInvBroj()).isPresent())
			listaOS.add(t);
		return 0;
	}

	@Override
	public void update(OsnovnoSredstvo t) {
		Optional<OsnovnoSredstvo> os = vratiPoInventarnomBroju(t.getInvBroj());
		if (os.isPresent())
			delete(os.get());
		save(t);
	}

	@Override
	public void delete(OsnovnoSredstvo t) {
		//Na cekanju zbog snimanja
//		if (t != null)
//			if(getByInvBroj(t.getInvBroj()).isPresent())
//			listaOS.remove(t);
	}

	@Override
	public void printAll() throws DataNotPresent {
		if(listaOS.isEmpty())
			throw new DataNotPresent("Ne postoji nijedan zapis");
		else
			listaOS.stream().forEach(System.out::println);
	}

	//sta radimo sa ovim?
	@Override
	public OsnovnoSredstvo makeCopyOfMe(OsnovnoSredstvo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
