package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SingleConn {
	private SingleConn(){
		
	}
	
	public static Connection getConn(){
		Connection conn=null;
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn =    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wmsbd5568533");
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void Close(ResultSet rs,Statement st,Connection conn){
		try {
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
