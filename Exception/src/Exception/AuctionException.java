package Exception;
/**
 * 自定义异常类
 * @author Administrator
 *
 */
public class AuctionException extends Exception {
	//空参构造器
	public AuctionException() {
		
	}
	//带一个字符串参数的构造器
	public AuctionException(String str) {
		super(str);
	}

}
