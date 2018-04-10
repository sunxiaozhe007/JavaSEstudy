package cn.sun.stringbuilder;
/**
 * 测试可变字符序列。StringBuilder（县城不安全，效率高）StringBuffer（线程安全，效率低）
 * String：不可变字符序列
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();//默认字符数组长度初始为16
		StringBuilder sb1 = new StringBuilder(32);//字符数组长度初始为32
		StringBuilder sb2 = new StringBuilder("abcd");
		sb2.append("efg");
		sb2.append(true).append(321).append("随便");
		System.out.println(sb2);
		
		System.out.println("##################");
		StringBuilder gh = new StringBuilder("a");
		for (int i=0;i<100;i++) {
			gh.append(i);
		}
		System.out.println(gh);
	}

}
