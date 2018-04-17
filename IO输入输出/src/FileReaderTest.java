import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用FileReaderTest读取自身
 * @author Administrator
 *
 */
public class FileReaderTest {
	public static void main(String[] args) throws IOException {
		try {
			//创建字符输入流
			FileReader f = new FileReader("D:\\JAVA文件\\IO输入输出\\src\\FileReaderTest.java");
			char[] cbuf = new char[32];
			//实际读取的字符数
			int hasRead = 0;
			//循环重复读取
			while((hasRead = f.read(cbuf)) > 0){
				{
					System.out.println(new String(cbuf , 0 , hasRead));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
