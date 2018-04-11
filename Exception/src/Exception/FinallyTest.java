package Exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用finally块回收在try块中打开的物理资源
 * @author Administrator
 *
 */
public class FinallyTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("a.text");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
			return ;
		}
		finally
		{
			//关闭磁盘，回收资源
			if (fis !=null ) {
				try {
					fis.close();
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}	
			}
			System.out.println("执行finally块里的资源回收！");
		}	
	}
}
