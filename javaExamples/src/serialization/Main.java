package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SS{}
class SubPerson extends Person {
	String sub;
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
 //       out.writeObject(name);
   //     out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
 //       in.defaultReadObject();
 //       name = (String) in.readObject();
 //      age = in.readInt();
    }
}
public class Main {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "vishal..";
		p1.age = 25;
		
		Person p2 = new Person();
		p2.name = "hey..";
		p2.age = 5;
		
		String fileName = "data.txt";
	//	serialize(p1,p2, fileName);
		
		SubPerson sp = new SubPerson();
		sp.age=10;
		sp.name="aaaa";
		sp.sub = "sub";
		serialize(sp,p2, fileName);
		
		
		deserialize(fileName);
		
	}

	private static void deserialize(String fileName) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			
			SubPerson p = (SubPerson)in.readObject();
		//	Person p1 = (Person)in.readObject();
			System.out.println( "person name " + p.name + "; age = " + p.age + "---"+ p.sub);
			//System.out.println( "person name " + p1.name + "; age = " + p1.age);
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

	private static void serialize(SubPerson p1,Person p2, String fileName) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(p1);
			//os.writeObject(p2);
			System.out.println("write operation completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
