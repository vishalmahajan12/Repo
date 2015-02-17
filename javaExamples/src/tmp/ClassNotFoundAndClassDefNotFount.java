package tmp;

public class ClassNotFoundAndClassDefNotFount {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object a = Class.forName("tmp.A").newInstance();
		System.out.println(a.getClass().getName());
	}
}
