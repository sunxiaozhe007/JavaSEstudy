package Exception;
/**
 * 使用throws声明抛出异常
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsTest {
	public static void test() throws IOException {
		//FileInputStream构造器声明抛出IOException异常
		//调用FileInputStream的代码要么处于try...catch块中
		//要么处于另一个带throws声明抛出的方法中
		FileInputStream s = new FileInputStream("a.txt");
	}
	public static void main(String[] args) throws Exception {
		//应为test（）方法声明抛出IOException异常
		//所以调用的方法应处于try...catch块或另一个带throws声明抛出的方法中
		  		test();
		}

	}
