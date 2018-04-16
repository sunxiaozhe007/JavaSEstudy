package cn.sun.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("aaa");
		list.add(new Date());
		list.add(1234);//1234,自动装箱
		
		System.out.println(list.size());
		
		System.out.println(list.isEmpty());
		
		//list.remove("aaa");
		//System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.addAll(list2);
		list.remove(0);
		System.out.println(list.size());
		
		
	}

}
