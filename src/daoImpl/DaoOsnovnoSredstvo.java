package daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import dao.Dao;
import domen.OsnovnoSredstvo;

public class DaoOsnovnoSredstvo implements Dao<OsnovnoSredstvo> {
	private final List<OsnovnoSredstvo> listaOS = new ArrayList<OsnovnoSredstvo>();

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
	public void loadAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<OsnovnoSredstvo> getAllByPredicate(Predicate<OsnovnoSredstvo> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(OsnovnoSredstvo t) {
		if(t != null && !getByInvBroj(t.getInvBroj()).isPresent())
			listaOS.add(t);
		return 0;
	}

	@Override
	public void update(OsnovnoSredstvo t) {
		Optional<OsnovnoSredstvo> os = getByInvBroj(t.getInvBroj());
		if(os.isPresent())
			delete(os.get());
		save(t);
	}

	@Override
	public void delete(OsnovnoSredstvo t) {
		if(t != null)
//			if(getByInvBroj(t.getInvBroj()).isPresent())
				listaOS.remove(t);
	}

	@Override
	public void printAll() {
		listaOS.stream().forEach(System.out::println);
	}

	@Override
	public OsnovnoSredstvo makeCopyOfMe(OsnovnoSredstvo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
