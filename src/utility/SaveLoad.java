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
import java.util.List;

import domen.OsnovnoSredstvo;

public class SaveLoad {

	public static <T> List<T> readObjectsFromFile(String filename) {

		List<T> objects = new ArrayList<>();
		try (FileInputStream in = new FileInputStream(filename); ObjectInputStream oin = new ObjectInputStream(in);) {

			while (true) {
				try {
					@SuppressWarnings("unchecked")
					T object = (T) oin.readObject();
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

	public static <T> void writeObjectsToFile(File filename, List<T> objects) throws IOException {
		if (filename.exists()) {
			filename.delete();
		}
		filename.createNewFile();
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename.getName()))) {
			for (T object : objects) {
				out.writeObject(object);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
