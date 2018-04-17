import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *重定向标准输出流
 * @author Administrator
 *
 */
public class RedirectOut {
	public static void main(String[] args) {
		try {
			//一次性创建	PrintStream 输出流
			PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
			//将标准输出重定向到ps输出流
			System.setOut(ps);
			//向标准输出输出一个字符串
			System.out.println("普通字符串");
			//向标准输出一个对象
			System.out.println(new RedirectOut());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}

