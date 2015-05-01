package questions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonWithSerialization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SingletonWithSerialization() {
		// TODO Auto-generated constructor stub
	}
	
	int i;
	public static SingletonWithSerialization singletonSer = new SingletonWithSerialization();
	
	public static SingletonWithSerialization getInstance()  {
		return singletonSer;
	}
	
   	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("file.ser"));
		SingletonWithSerialization instance = SingletonWithSerialization.getInstance();
		instance.i=20;
		os.writeObject(instance);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
		SingletonWithSerialization ser = (SingletonWithSerialization) in.readObject();
		
		System.out.println(ser == singletonSer);
		
		
	}
	
	private Object readResolve(){
		return SingletonWithSerialization.getInstance();
	}
}