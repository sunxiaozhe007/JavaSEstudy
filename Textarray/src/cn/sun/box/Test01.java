package cn.sun.box;
/**
 * 测试包装类基本用法
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Integer i = new Integer(1000);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(i));
		Integer i2 = Integer.parseInt("234");
		Integer i3 = new Integer("333");
		System.out.println(i2.intValue());
		
		String str = 234+"";
	}

}
