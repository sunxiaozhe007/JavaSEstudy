package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 测试执行SQL语句及SQL注入问题
 * @author Administrator
 *
 */
public class Statement {
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
			
			java.sql.Statement stmt = conn.createStatement();
			//测试插入
			//String sql = "insert into t_user(username,pwd,regTime) values ('wangwu',555,now())";
			//stmt.execute(sql);
			//测试SQL注入
			String id = "5 or 1=1";
			String sql = "delete from t_user where id=" + id;
			stmt.execute(sql);
			
			
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