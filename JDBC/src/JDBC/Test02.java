package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 测试事物基本概念和用法
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) throws InterruptedException {
		Connection conn = null;
		java.sql.PreparedStatement ps1 = null;
		java.sql.PreparedStatement ps2 = null; 

		
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
			conn.setAutoCommit(false);//自动提交事物

			ps1 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps1.setObject(1, "sun");
			ps1.setObject(2, "556778");
			ps1.execute();
			System.out.println("插入一条记录");
			
			
			Thread.sleep(2000);
			ps2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps2.setObject(1, "xiao");
			ps2.setObject(2, "1234");
			ps2.execute();
			System.out.println("插入一条记录");
			
			conn.commit();
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}finally {
							
				try {
					if (ps1!=null) {
						ps1.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					if (conn!=null) {
						conn.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	

}