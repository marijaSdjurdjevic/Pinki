package utility;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SaveLoad {

	

	
	public static <T> void writeObjectsToFile(String filepath, List<T> objects) {
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imam gde pisati");
		}
		if (objects != null) {
			try (FileOutputStream os = new FileOutputStream(filepath);
					ObjectOutputStream oos = new ObjectOutputStream(os);) {

				for (T object : objects) {
					oos.writeObject(object);
				}
				oos.flush();

			} catch (FileNotFoundException e) {
				System.out.println("Nema fajla za upis podataka  ");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static <T> List<T> readObjectsFromFile(String filename) {
		
		List<T> objects = new ArrayList<>();
		try (FileInputStream is = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(is);) {

			while (true) {
				try {
					@SuppressWarnings("unchecked")
					T object = (T) ois.readObject();
					objects.add((T) object);
				} catch (EOFException ex) {
					break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return objects;
		} catch (FileNotFoundException e1) {
			System.out.println("Nema fajla o zaposlenima");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Neuspesno ucitavanje");
		}

		return null;
	}

	public static <T, U> Map<T, U> readMapObjectsFromFile(String filename) {
		
		File f=new File(filename);
		if (f.exists()) {
			System.out.println("Imam odakle da ucitam ");
		}
		Map<T, U> objects = new HashMap<>();
		try (FileInputStream is = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(is);) {

			while (true) {
				try {
					HashMap object = (HashMap<T, U>) ois.readObject();

				} catch (EOFException ex) {
					break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return objects;
		} catch (FileNotFoundException e1) {
			System.out.println("Nema fajla o zaposlenima");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Neuspesno ucitavanje");
		}

		return null;
	}

	public static <T, U> void writeMapToFile(String filepath, Map<T, U> objects) {
		
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imam gde da upisujem ");
		}
		
		try (FileOutputStream os = new FileOutputStream(filepath);
				ObjectOutputStream oos = new ObjectOutputStream(os);) {

			oos.writeObject(objects);

			oos.flush();

		} catch (FileNotFoundException e) {
			System.out.println("Nema fajla za upis podataka  ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
