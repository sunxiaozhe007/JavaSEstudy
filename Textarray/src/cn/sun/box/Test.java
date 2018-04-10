package cn.sun.box;

public class Test {  
	  
    public static void main(String[] args) {  
          
        Integer i = new Integer(128);  
        Integer i2 = 128;  
          
        System.out.println(i == i2);  
          
        Integer i3 = new Integer(127);  
        Integer i4 = 127;  
        System.out.println(i3 == i4);  
          
        Integer i5 = 128;  
        Integer i6 = 128;  
        System.out.println(i5 == i6);  
          
        Integer i7 = 127;  
        Integer i8 = 127;  
        System.out.println(i7 == i8);  
    }  
} 