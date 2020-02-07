package dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public  interface Dao<T> {
	 
    Optional<T> getBySifra(int sifra);
    Optional<T> getByNaziv(String naziv);
    void loadAll();
    void saveAll();
    
    Collection<T> getAllByPredicate(Predicate<T> predicate);
    int save(T t);
    void update(T t);
    void delete(T t);
    void printAll();
    T makeCopyOfMe(T t);
   
    
    
}
