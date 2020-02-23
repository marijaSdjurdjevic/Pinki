package dao;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import exceptions.DataNotPresent;

public  interface Dao<T> {
	 
    public Optional<T> vratiPoSifri(int sifra);
    
    public void ucitajPodatke() throws Exception;
    public void upisiPodatke() throws IOException;
    
    Collection<T> vratiPoUslovu(Comparator<T> predicate);
    int save(T t);
    void update(T t);
    void delete(T t);
    void printAll() throws DataNotPresent;
    T makeCopyOfMe(T t);
   
    
    
}
