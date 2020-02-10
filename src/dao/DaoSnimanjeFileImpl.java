package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import domen.*;

public class DaoSnimanjeFileImpl implements DaoSnimanje, Serializable {

	private static List<Snimanje> list;
	private static String file = "./snimanja.dat";
	
	
	private DaoSnimanjeFileImpl() {
		super();
	}

	public List<Snimanje> getInstance() {
		if (list == null) {
			list = new ArrayList<Snimanje>();
		}
		return list;
	}

	@Override
	public Optional getBySifra(int sifra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional getByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadAll() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(file)))){
			Snimanje temp = (Snimanje) ois.readObject();
			while(temp != null) {
				list.add(temp);
				temp = (Snimanje) ois.readObject();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void saveAll() {
		

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(file)))){
			Iterator<Snimanje> it = list.iterator();
			while(it.hasNext()) {
				list.add((Snimanje) it.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Collection getAllByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object makeCopyOfMe(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}
