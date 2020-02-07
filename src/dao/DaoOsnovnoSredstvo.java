package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import domen.osnovnoSredstvo;

public class DaoOsnovnoSredstvo implements Dao<DaoOsnovnoSredstvo> {
	private final List<osnovnoSredstvo> listaOS = new ArrayList<osnovnoSredstvo>();

	@Override
	public Optional<DaoOsnovnoSredstvo> getBySifra(int sifra) {
//		DaoOsnovnoSredstvo o = listaOS.stream().filter((os) -> os.getInvbrojevi().equals(sifra)).findFirst();
		return null;
	}

	@Override
	public Optional<DaoOsnovnoSredstvo> getByNaziv(String naziv) {
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
	public Collection<DaoOsnovnoSredstvo> getAllByPredicate(Predicate<DaoOsnovnoSredstvo> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(DaoOsnovnoSredstvo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(DaoOsnovnoSredstvo t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DaoOsnovnoSredstvo t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public DaoOsnovnoSredstvo makeCopyOfMe(DaoOsnovnoSredstvo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
