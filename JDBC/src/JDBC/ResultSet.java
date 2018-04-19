package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试ResultSet基本用法
 * @author Administrator
 *
 */
public class ResultSet {
	public static void main(String[] args) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null; 
		java.sql.ResultSet rs = null;
		
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
		
			String sql = "select id,username,pwd from t_user where id>?";//占位符
			ps = conn.prepareStatement(sql);
			//把id大于2 的记录取出
			ps.setObject(1, 2);
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
			//遵照resultset-->statment-->connection的顺序关闭
				try {			
					if (rs!=null) {
					rs.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
			}
				try {
					if (ps!=null) {
						ps.close();
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