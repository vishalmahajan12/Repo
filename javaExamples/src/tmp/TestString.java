package tmp;



public class TestString {

	public static void main(String[] args) {
		String s = new String("abc").intern();
		String s1 = "abc";
		
		System.out.println(s == s1);
		System.out.println(s.equals(s1));
	}
}
