import java.io.RandomAccessFile;
/**
 * 只读方式打开文件
 * @author Administrator
 *
 */
public class RandomAccessFileTest {
	public static void main(String[] args) {
		try(
				RandomAccessFile raf = new RandomAccessFile("D:\\JAVA文件\\IO输入输出\\src\\RandomAccessFileTest.java" , "r"))
				{
					System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
					raf.seek(300);
					byte[] bbuf = new byte[1024];
					int hasRead = 0;
					while((hasRead = raf.read(bbuf)) > 0)
					{
						System.out.println(new String(bbuf , 0 , hasRead));
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
	}

}
