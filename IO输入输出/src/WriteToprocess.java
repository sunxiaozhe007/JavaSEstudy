import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * 
 * @author Administrator
 *
 */
public class WriteToprocess {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try 
		(
			PrintStream ps = new PrintStream(p.getOutputStream()))
		{
			ps.println("普通字符串");
			ps.println(new WriteToprocess());
		}
	}
}
class ReadStandard
{
	public static void main(String[] args){
		try(
				Scanner sc = new Scanner(System.in);
				PrintStream ps = new PrintStream(new FileOutputStream("out2.txt")))
		{
			sc.useDelimiter("\n");
			while(sc.hasNext())
			{
				ps.println("键盘输入内容是："+sc.next());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
