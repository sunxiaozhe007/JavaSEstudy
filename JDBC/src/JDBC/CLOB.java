package JDBC;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试Clob文本大对象
 * @author Administrator
 *
 */
public class CLOB {
	public static void main(String[] args) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null; 
		java.sql.ResultSet rs = null;
		
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
		
			ps = conn.prepareStatement("insert into t_user (username,myinfo) values (?,?)");
			ps.setString(1, "sun");
			//将文本文件输入到数据库中
			ps.setClob(2, new FileReader(new File("D:\\sxz.txt")));
			
			ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			
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