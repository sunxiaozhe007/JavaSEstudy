import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 键盘读取
 * @author Administrator
 *
 */
public class KeyinTest {
	public static void main(String[] args) throws IOException {
		//将System.in对象转化成Reader对象
		InputStreamReader reader = new InputStreamReader(System.in);
		//将普通Reader包装成BufferedReader
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		//循环逐行读取
		while ((line = br.readLine()) !=null)
		{
			//读取到exit退出
			if(line.equals("exit"))
			{
				System.exit(1);
			}
			//打印读取内容
			System.out.println("输入内容为："+line);
		}
	}
}
