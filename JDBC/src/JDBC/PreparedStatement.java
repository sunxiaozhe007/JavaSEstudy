package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 测试PreparedStatement基本用法
 * @author Administrator
 *
 */
public class PreparedStatement {
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
			String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";//占位符
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "sunxiaozhe");
			ps.setString(2, "12345");
			ps.setDate(3, new  java.sql.Date(System.currentTimeMillis()) );
			System.out.println("插入一条记录");
			ps.execute();
			
		
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