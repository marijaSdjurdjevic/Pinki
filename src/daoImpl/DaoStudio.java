package daoImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dao.Dao;
import domen.Studio;
import utility.SaveLoad;

public class DaoStudio implements Dao<Studio> {
	
	private static final String fileOfStudio = "C:\\Users\\dragan.markovic\\podaci\\Studio";

	List<Studio> listOfStudio;

	@Override
	public Optional<Studio> getBySifra(int sifra) {
		return this.listOfStudio.parallelStream().filter(z -> z.getId() == sifra).findFirst();
	}

	@Override
	public Optional<Studio> getByNaziv(String naziv) {

		return this.listOfStudio.parallelStream().filter(z -> z.getNaziv() == naziv).findFirst();
	}

	@Override
	public void loadAll() {
		listOfStudio = SaveLoad.readObjectsFromFile(fileOfStudio);

	}

	@Override
	public void saveAll() {
		SaveLoad.writeObjectsToFile(fileOfStudio,listOfStudio);
		
	}

	@Override
	public Collection<Studio> getAllByPredicate(Predicate<Studio> predicate) {
		List<Studio> lista = listOfStudio.stream().filter(predicate).collect(Collectors.toList());
		return lista;
	}

	@Override
	public int save(Studio t) {
		if (t == null || !(t instanceof Studio)) {
			throw new NullPointerException("Studio ne sme biti null");
		} else {
			Studio tTemp = (Studio) t;
			listOfStudio.add(tTemp);
			SaveLoad.writeObjectsToFile(fileOfStudio,listOfStudio );
			return 1;
		}
	}

	@Override
	public void update(Studio studio) {

		Optional<Studio> oZap = this.getBySifra(studio.getId());
		if (!oZap.isPresent()) {
			System.out.println("Ne postoji korisnik sa sifrom "+studio.getId());
		}

		Studio zap = oZap.get();
		zap.setId(studio.getId());
		zap.setNaziv(studio.getNaziv());
		zap.setOpis(studio.getOpis());
		zap.setLokacija(studio.getLokacija());
	}

	@Override
	public void delete(Studio t) {
		if (t == null) {
			throw new NullPointerException("projekat ne sme biti null");
		} else {
			Studio tTemp = (Studio) t;
			listOfStudio.remove(tTemp);
		}
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Studio makeCopyOfMe(Studio t) {
		// TODO Auto-generated method stub
		return null;
	}

}
