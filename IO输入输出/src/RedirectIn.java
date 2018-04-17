import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * 
 * @author Administrator
 *
 */
public class RedirectIn {
	public static void main(String[] args) {
		FileInputStream fis;
		try {
			//将标准输入重定向到fis输入流
			fis = new FileInputStream("D:\\JAVA文件\\IO输入输出\\src\\RedirectIn.java");
		System.setIn(fis);
		//使用System.in创建Scanner对象，用于获取标准输入
		Scanner sc = new Scanner(System.in);
		//增加下面一行只把回车作为分隔符
		sc.useDelimiter("\n");
		//判断是否还有下一个输入项
		while(sc.hasNext())
		{
			//输出输入项
			System.out.println("键盘输入内容是："+ sc.next());
		}
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
}
