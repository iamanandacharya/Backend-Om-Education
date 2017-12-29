package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionHandler {

	static Connection cn=null;
	private ConnectionHandler(){
		
	}
	
	public static Connection getConn(){
		if(cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","anand");
				return cn;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return cn;
		}
		return cn;
	}
}
