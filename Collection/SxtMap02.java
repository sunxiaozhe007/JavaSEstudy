package cn.sun.collection;

import java.util.LinkedList;

/**
 * 自定义实现Map功能
 * 提高查询效率
 * @author Administrator
 *
 */
public class SxtMap02 {
	LinkedList[] arr = new LinkedList[999];
	int size;
	
	public void put(Object key,Object value) {
		SxtEntry e = new SxtEntry(key,value);
		int a = key.hashCode()%arr.length;
		//a:1000-->1   b:1000-->13
		if(arr[a]==null) {
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);
		}else {
			
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e2 = (SxtEntry)list.get(i);
				if(e.key.equals(key)) {
					e2.value = value;//键重负直接覆盖
				return;
					}
				}
			arr[a].add(e);
			}	
		}
	
	
	public Object get(Object key) {
		//return arr[key.hashCode()%999];
		int a = key.hashCode()%arr.length;
		if(arr[a]!=null) {
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e = (SxtEntry)list.get(i);
				if(e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		SxtMap02 m = new SxtMap02();
		m.put("孙", new Wife("sun"));
		m.put("孙", new Wife("xiao"));
		m.put("哲", new Wife("zhe"));
		Wife w = (Wife) m.get("孙");
		System.out.println(w.name);
		
	}
	

}
