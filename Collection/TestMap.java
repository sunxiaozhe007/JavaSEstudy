package cn.sun.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的基本用法
 * @author Administrator
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("sunxiaozhe", new Wife("zhang"));
		map.put("sunx", new Wife("zheng"));
		map.put("zhe", new Wife("zhao"));
		
		map.remove("zhe");
		Wife w = (Wife)map.get("sunx");
		System.out.println(w.name);
		map.containsKey("zheee");
		
	}
	
	
	 
 
}
class Wife{
	String name;

	public Wife(String name) {
		super();
		this.name = name;
	}
	
}
