import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStrem/FileOutputStream
 * @author Administrator
 *
 */
public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException {
		try {
			//创建字节输入流
			FileInputStream fis = new FileInputStream("D:\\JAVA文件\\IO输入输出\\src\\FileOutputStreamTest.java");
			//创建字节输出流
			FileOutputStream fos = new FileOutputStream("newFile.txt");
			{
				byte[] bbuf = new byte[32];
				int hasread = 0;
				//循环读取数据
				while((hasread = fis.read(bbuf)) > 0)
				{
					//读取一次写入一次
					fos.write(bbuf , 0 , hasread); 
				}
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
