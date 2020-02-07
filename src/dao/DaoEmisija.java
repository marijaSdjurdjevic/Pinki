package dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DaoEmisija<T> extends dao.Dao<T>{

	@Override
	default Optional<T> getBySifra(int sifra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Optional<T> getByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void loadAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void saveAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default Collection<T> getAllByPredicate(Predicate<T> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default int save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void printAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default T makeCopyOfMe(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
