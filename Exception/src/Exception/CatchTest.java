package Exception;

/**
 * 使用一个catch块捕获多种类型异常
 * @author Administrator
 *
 */
public class CatchTest {
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[0]);
			int c = a / b;
			System.out.println(c);
		}
		catch(IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie)
		{
			System.out.println("程序发生了数组越界，数字格式异常，算数异常之一");
			//捕获多种异常时，异常变量有默认final修饰
			//ie = new ArithmeticException("test");这段代码有错
		}
		catch(Exception e)
		{
			System.out.println("未知异常");
			//捕获一种异常时，异常变量没有final修饰
			e = new RuntimeException("test");
		}
	}

}
