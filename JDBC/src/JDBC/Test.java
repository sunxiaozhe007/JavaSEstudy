package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试批处理基本用法
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		java.sql.Statement stmt = null; 
		java.sql.ResultSet rs = null;
		
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","0528");
			//设为手动提交
			conn.setAutoCommit(false);
			
			long start = System.currentTimeMillis();
			stmt = conn.createStatement();
			
			for (int i = 0; i < 2000; i++) {
				stmt.addBatch("insert into t_user (username,pwd,regTime) values ('sun"+i+"',66666,now())");
				
			}
			stmt.executeBatch();
			conn.commit();//提交事务
			long end = System.currentTimeMillis();
			System.out.println("插入两千条记录，耗时："+(end - start)+"毫秒");
	
			
		
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
					if (stmt!=null) {
						stmt.close();
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