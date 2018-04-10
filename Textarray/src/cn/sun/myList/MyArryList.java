package cn.sun.myList;
/**
 * 模拟实现JDK中提供的ArryList类
 * @author Administrator
 *
 */
public class MyArryList {
	 /**
     * The value is used for character storage.
     */
   private Object[] value;

    /**
     * The id of the encoding used to encode the bytes in {@code value}.
     */
   private int size;
	
	public MyArryList() {
		//value = new Object[16];
		this(16);
	}
	public MyArryList(int size) {
		value = new Object[size];
	}
	public int size() {
		return size;
		
	}
	public void add(Object obj) {
		value[size] = obj;
		size++;
		if(size>=value.length) {
			//扩容
			int newCapacity = value.length*2;
			Object [] newList = new Object[newCapacity];
			for(int i=0; i<value.length;i++) {
				newList [i] = value[i];
			}
			value = newList;
		}
	}
	
	public Object get(int index) {
		if(index <0 || index > size-1) {//[0,size-1]
            try {
            	throw new Exception();
            }catch (Exception e) {
            	e.printStackTrace();
            }
		}
		return value[index];
		
	}
public static void main(String[] args) {
	 MyArryList list = new  MyArryList (2);
	 list.add("aaa");
	 list.add(new Human("sunxiaozhe"));
	 list.add("bbb");
	 list.add("bbb");
	 list.add("bbb");
	 list.add("bbb");
	 list.add("bbb");
	 list.add("bbb");
	 Human h =(Human) list.get(1);
	 //System.out.println(h.getName());
	 //System.out.println(list.get(2));
	 System.out.println(list.size());
}
}
