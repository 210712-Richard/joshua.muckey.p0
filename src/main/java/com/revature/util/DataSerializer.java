package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSerializer<T> {

	// Generic Type - Replace all instances of an object type with a variable type T

	@SuppressWarnings("unchecked")
	public T readObjectFromFile(String filename) throws IOException{
		T object = null;
		try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));) {
			
			object = (T) o.readObject();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
