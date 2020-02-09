package daoImpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import dao.Dao;
import domen.OsnovnoSredstvo;
import utility.SaveLoad;

public class DaoOsnovnoSredstvo implements Dao<OsnovnoSredstvo> {
	private List<OsnovnoSredstvo> listaOS = new ArrayList<OsnovnoSredstvo>();
	private final File os = new File("OsnovnaSredstva");

	public DaoOsnovnoSredstvo() throws Exception {
		if (!os.exists())
			os.createNewFile();
		else {
			try {
				loadAll();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@Override
	public Optional<OsnovnoSredstvo> getBySifra(int sifra) {
		return listaOS.stream().filter((os) -> Integer.compare(os.getId(), sifra) == 0).findFirst();
	}

	public Optional<OsnovnoSredstvo> getByInvBroj(String invBroj) {
		return listaOS.stream().filter((os) -> os.getInvBroj().equalsIgnoreCase(invBroj)).findFirst();
	}

	public Optional<OsnovnoSredstvo> getByNaziv(String invBroj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadAll() throws Exception {
		// mozda ovo da uradimo preko optionala?
		listaOS = SaveLoad.readObjectsFromFile("OsnovnaSredstva");

	}

	@Override
	public void saveAll() throws IOException {
		SaveLoad.writeObjectsToFile(os, listaOS);

	}

	@Override
	public Collection<OsnovnoSredstvo> getAllByPredicate(Predicate<OsnovnoSredstvo> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(OsnovnoSredstvo t) {
		if (t != null && !getByInvBroj(t.getInvBroj()).isPresent())
			listaOS.add(t);
		return 0;
	}

	@Override
	public void update(OsnovnoSredstvo t) {
		Optional<OsnovnoSredstvo> os = getByInvBroj(t.getInvBroj());
		if (os.isPresent())
			delete(os.get());
		save(t);
	}

	@Override
	public void delete(OsnovnoSredstvo t) {
		if (t != null)
//			if(getByInvBroj(t.getInvBroj()).isPresent())
			listaOS.remove(t);
	}

	@Override
	public void printAll() {
		listaOS.stream().forEach(System.out::println);
	}

	//sta radimo sa ovim?
	@Override
	public OsnovnoSredstvo makeCopyOfMe(OsnovnoSredstvo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
