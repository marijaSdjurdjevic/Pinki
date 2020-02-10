package dao;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public  interface Dao<T> {
	 
    Optional<T> getBySifra(int sifra);
    List<T> getByNaziv(String naziv);
    //dodat exceptione
    void loadAll() throws Exception;
    void saveAll() throws IOException;
    
    Collection<T> getAllByPredicate(Comparator<T> predicate);
    int save(T t);
    void update(T t);
    void delete(T t);
    void printAll();
    T makeCopyOfMe(T t);
   
    
    
}
