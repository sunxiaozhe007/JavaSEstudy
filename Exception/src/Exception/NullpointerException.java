package Exception;

import java.util.Date;

/**
 * NullpointerException异常
 * @author Administrator
 *
 */
public class NullpointerException {
	public static void main(String[] args) {
		Date d = null;
		try
		{
			System.out.println(d.after(new Date()));
		}
		catch(NullPointerException ne)
		{
			System.out.println("空指针异常");
		}
		catch(Exception e)
		{
			System.out.println("未知异常");
		}
	}

	

}
