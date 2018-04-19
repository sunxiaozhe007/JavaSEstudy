package JDBC;
/**
 * 通过ResultSet获得结果集
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnMysql {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/select_test?useSSL=true" , "root" , "0528");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select s.* , teacher_name"
				+"from student_table s , teacher_table t"
				+"where t.teacher_id = s.java_teacher");
		while (rs.next())
		{
			System.out.println(rs.getInt(1) + "\t"
			+ rs.getString(2) + "\t"
			+ rs.getString(3) + "\t"
			+ rs.getString(4));
		}
	}

}
