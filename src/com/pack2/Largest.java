package com.pack2;

public class Largest {
	public static int largest(int[] list) {
		int index;
		int max=Integer.MIN_VALUE;
		if(list.length==0){
			throw new RuntimeException();
		}
		for (index = 0; index <= list.length-1; index++) {
			if (list[index] > max) {
				max = list[index];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] list={7,8,9,3,23,44,6,44};
		System.out.println(largest(list));
		System.out.println(list.length);
	}

}
