package java8;

import java8.functionalinterface.Service;

public class Test {
	public static void main(String[] args) {
		Service aa;
		aa = (f, j) -> {
			int k = f * j;
			return k;
		};
		System.out.println(aa.getValue(10, 5));
		System.out.println(aa.getName());
		System.out.println(aa);

		aa = (i, j) -> i + j;
		System.out.println(aa.getValue(10, 5));
		System.out.println(aa);

	}

}

