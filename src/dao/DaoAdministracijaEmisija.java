package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import domen.AdministracijaEmisija;

public class DaoAdministracijaEmisija implements DaoEmisija<AdministracijaEmisija> {

	private List<AdministracijaEmisija> listaEmisija = new ArrayList<AdministracijaEmisija>();
	Optional o;

	@Override
	public Optional<AdministracijaEmisija> getBySifra(int sifra) {

		for (AdministracijaEmisija administracijaEmisija : listaEmisija) {
			if (administracijaEmisija.getId() == sifra)
				return Optional.of(administracijaEmisija);
		}
		return Optional.empty();
	}

	@Override
	public Optional getByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return DaoEmisija.super.getByNaziv(naziv);
	}

	@Override
	public void loadAll() {
		// TODO Auto-generated method stub
		DaoEmisija.super.loadAll();
	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub
		DaoEmisija.super.saveAll();
	}

	@Override
	public Collection getAllByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return DaoEmisija.super.getAllByPredicate(predicate);
	}

	@Override
	public int save(Object t) {
		// TODO Auto-generated method stub
		return DaoEmisija.super.save(t);
	}

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub
		DaoEmisija.super.update(t);
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		DaoEmisija.super.delete(t);
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		DaoEmisija.super.printAll();
	}

	@Override
	public Object makeCopyOfMe(Object t) {
		// TODO Auto-generated method stub
		return DaoEmisija.super.makeCopyOfMe(t);
	}

}
