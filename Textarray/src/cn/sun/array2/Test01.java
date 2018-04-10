package cn.sun.array2;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		//int a[][] = {{1,2},{3,4,0,9},{5,6,7}};
		int a[] = {7,45,34,1,2};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for (int i : a) {
			System.out.println(i);
		}
	}

}
