import java.io.FileInputStream;
import java.io.IOException;
/**
 * FileInputStream读取自身
 * @author Administrator
 *
 */

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		//创建字节输入流
		FileInputStream fis = new FileInputStream("D:\\JAVA文件\\IO输入输出\\src\\FileInputStreamTest.java");
		byte[] bbuf = new byte[1024];
		//保存实际读取的字节数
		int hasread = 0;
		//使用循环来重复读取
		while((hasread = fis.read(bbuf)) > 0)
		{
			//取出字节，将字节转换成字符串输入
			System.out.println(new String(bbuf , 0 , hasread));
		}
		//关闭文件输入流
		fis.close();
	}
}
