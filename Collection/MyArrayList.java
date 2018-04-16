package cn.sun.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现一个ArrayList
 * @author Administrator
 *
 */
public class MyArrayList {
	
	private Object[] elementData;
	
	private int size;
	public int size() {
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	
	
	public MyArrayList() {
		this(10);
	}
	
	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		elementData = new Object[initialCapacity];
	}
	
	
	public void add(Object obj) {
		//扩容
		ensure();
		//if(size==elementData.length)
		//{
			//Object[] newArray = new Object[size*2+1];
			//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			//for(int i=0;i<elementData.length;i++) 
			//{
				//newArray[i] = elementData[i];
			//}
			//elementData = newArray;
		//}
		
		elementData[size++]=obj;
	}
	
	private void ensure() {//扩容
		
		if(size==elementData.length) {
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			//for(int i=0;i<elementData.length;i++) 
			//{
				//newArray[i] = elementData[i];
			//}
			elementData = newArray;
		}
		
	}
	
	
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
		
	}
	
	
	public Object set(int index,Object obj) {
		rangeCheck(index);
		 Object oldValue = elementData[index];
		 elementData[index] = obj;
		 return oldValue;
	}
	
	
	public void rangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void remove(int index) {
		//删除指定位置的对象
		//a b c d e 
		rangeCheck(index);
		int numNoved = size - index - 1;
		if(numNoved > 0) {
			System.arraycopy(elementData, index+1, elementData, index, numNoved);	
		}
		elementData[--size] = null;
	}
	
	
	public void remove(Object obj) {
		for(int i = 0; i < size; i++) {
			if(get(i).equals(obj)) {
				remove(i);
			}
		}
			
	}
	
	
	public void add(int index,Object obj) {
		rangeCheck(index);
		ensure();
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}
	
	public static void main(String[] args) {
	
		MyArrayList list = new MyArrayList(3);
		list.add("333");
		list.add("444");
		list.add("555");
		list.add("666");
		list.add("888");
		list.add("999");
		list.add("8828");
		list.add("111");
	
		System.out.println(list.size());
		System.out.println(list.get(9));
	}
	
}
