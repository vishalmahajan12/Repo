package questions;

public class SearchSubArrayFromLargeArray {
	int result = -1;

	public static void main(String[] args) {
		SearchSubArrayFromLargeArray s = new SearchSubArrayFromLargeArray();
		int[] largeArray = { 4, 5, 8, 2, 5, 7, 8, 5, 2 };
		int[] subArray = { 8 };
		long start = System.nanoTime();
		System.out.println(s.searchSubArray(largeArray, subArray));
		long total = System.nanoTime() - start;
		System.out.println(total);
	}

	public int searchSubArray(int[] largeArray, int[] subArray) {
		for (int i = 0; i < largeArray.length; i++) {
			boolean match = false;
			if (largeArray[i] == subArray[0]) {
				if (subArray.length == 1)
					match = true;
				for (int j = 1; (i + j) < largeArray.length	&& j < subArray.length; j++) {
					if (largeArray[i + j] == subArray[j]) {
						match = true;
					} else {
						match = false;
						break;
					}
				}
			}
			if (match == true) {
				result = i;
				break;
			}
		}
		return result;
	}
}