import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 使用PrintStream处理流来包装OutputStream
 * @author Administrator
 *
 */
public class PrintStreamTest {
	public static void main(String[] args) throws IOException {
		try (
			FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos))
			{
				ps.println("普通字符串");
				ps.println(new PrintStreamTest());
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

}
