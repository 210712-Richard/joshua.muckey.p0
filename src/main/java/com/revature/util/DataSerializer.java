package com.revature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSerializer<T> {

	// Generic Type - Replace all instances of an object type with a variable type T

	@SuppressWarnings("unchecked")
	public T readObjectFromFile(String filename) {
		T object = null;
		try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));) {
			
			object = (T) o.readObject();

		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		return object;
	}

	public void writeObjectsToFile(T object, String filename) {
		try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));) {
			o.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
