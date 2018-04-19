package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 测试链接数据库
 * @author Administrator
 *
 */
public class TestJDBC {
	public static void main(String[] args) {
		try {
			//加载驱动类
			long start = System.currentTimeMillis();
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
			long end = System.currentTimeMillis();
			System.out.println(conn);
			System.out.println("建立连接，耗时："+(end-start)+"毫秒");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

}
