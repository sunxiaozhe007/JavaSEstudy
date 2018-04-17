import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 传入字符串节点
 * @author Administrator
 *
 */
public class StringNodeTest {
	public static void main(String[] args) {
		String src = "ssssssssssssssss\n"
				+ "xxxxxxxxxxxxxxxxxx"
				+ "zzzzzzzzzzzzzzzzzz"
				+ "dddddddddddddd"
				+ "ffffffffffffff"
				+ "gggggggggg"
				+ "sdsdadad";
		char[] buffer = new char[32];
		int hasRead = 0;
		try(
				StringReader sr = new StringReader(src))
		{
			while ((hasRead = sr.read(buffer)) > 0)
			{
				System.out.println(new String(buffer , 0 , hasRead));
			}
		}
		catch (IOException e) {
				e.printStackTrace();
		}
		
		StringWriter sw = new StringWriter();
		sw.write("ssssssssssssssssss,\n");
		sw.write("xxxxxxxxxxxxxxxxxx,\n");
		sw.write("zzzzzzzzzzzzzzzzzz,\n");
		System.out.println("下面是字符串节点里的内容");
		System.out.println(sw.toString());
	}
}	

