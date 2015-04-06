package collections;

public class HashKey {
	int a;

	@Override
	public boolean equals(Object obj) {
		return a == ((HashKey) obj).a;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public String toString() {
		return a + "";
	}
}