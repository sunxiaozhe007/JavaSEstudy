package cn.sun.array;
/**
 * 数组基本概念
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 23;
		a[1] = 28;
		a[2] = 32;
		Car[] c = new Car[3];
		c[0] = new Car("奔驰！");
		c[1] = new Car("奔驰");
		c[2] = new Car("奔");
		System.out.println(c[2].name);
		System.out.println(a.length);
		for (int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
			
		}
	}
