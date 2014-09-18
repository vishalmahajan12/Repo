package tmp;

public class Combinations {
	static int r = 1;
	public static void main(String[] args) {
		combine("11", new StringBuilder(), 0);
	}

	static void combine(String instr, StringBuilder stringBuilder, int index)
	{
		for (int i = index; i < instr.length(); i++)
		{
			stringBuilder.append(instr.charAt(i));
			System.out.println(stringBuilder);
			combine(instr, stringBuilder, i + 1);
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
	} 
}