package cn.sun.array;
/**
 * 数组基本语法
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//声明
		int[] a;
		int b[];
		//创建数组
		a = new int[4];
		b = new int[5];
		//初始化
		//默认初始化：数组元素相当于对象的成员变量，默认值跟成员变量规
		//动态初始化
		for(int i=0;i<a.length;i++) {
			a[i] = i*12;
		}
		//静态初始化
		int c[] = {23,45,56,34};
		Car[] c1 = {new Car("奔驰！"),new Car("奔驰"),new Car("奔")};
		System.out.println(c1[2].name);
	}
}
	
