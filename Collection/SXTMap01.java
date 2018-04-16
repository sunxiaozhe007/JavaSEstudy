package cn.sun.collection;
/**
 * 自定义实现Map功能
 * @author Administrator
 *Map：存放键值对，根据建对象找对应的对象，键不能重复
 */
public class SXTMap01 {
	SxtEntry[] arr = new SxtEntry[999];
	int size;
	
	
	public void put(Object key,Object value) {
		SxtEntry e = new SxtEntry(key,value);
		//键值重复，直接覆盖
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				arr[i].value = value;
				return ;
			}
		}
		
		arr[size++] = e;
		
	}
	
	
	public Object get(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				return arr[i].value;
			}
		}
		return null;
	}
	
	
	public boolean cantainsValue(Object value) {
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean cantainsKey(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	
public static void main(String[] args) {
	SXTMap01 m = new SXTMap01();
	m.put("孙", new Wife("sun"));
	m.put("孙", new Wife("xiao"));
	m.put("哲", new Wife("zhe"));
	Wife w = (Wife) m.get("孙");
	System.out.println(w.name);
}
	
		
}
class SxtEntry{
	Object key;
	Object value;
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

}
