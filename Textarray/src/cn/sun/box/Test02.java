package cn.sun.box;
/**
 * 测试自动装箱和拆箱
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//Integer a = new Integer(1000);
		Integer a = 1000;//JDK5.0之后，自动装箱
		Integer b = 2000;
		
		//int c = new Integer(1500);//编译器改进：new Integer.intValue();
		int c = b;
		System.out.println(c);
		Integer d = 1234;
		Integer d2 = 1234;
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		System.out.println("###################################");
		Integer d3 = 123;//[-128,127]之间的仍然当作基本数据类型
		Integer d4 = 123;
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
			
	}

}
