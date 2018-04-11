package Exception;
/**
 * catch和throw同时使用
 * @author Administrator
 *
 */

public class AuctionTest {
	private double initprice = 30.0;
	public void bid (String bidPrice) throws AuctionException {
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		}
		catch(Exception e){
			//控制台打印异常的跟踪栈信息
			e.printStackTrace();
			//抛出自定义异常
			throw new AuctionException("必须是数值，不能包含其他字符");
		}
		if (initprice > d) {
			throw new AuctionException("aaaaaaaa");
		}
		initprice = d;
	}
	public static void main(String[] args) {
		AuctionTest a = new AuctionTest();
		try {
			a.bid("vvvv");
		}
		catch (AuctionException e) {
			//捕获到bid（）方法中的异常，并进行处理
			System.out.println(e.getMessage());
		}
	}

}
