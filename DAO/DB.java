package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
public static Connection con = null;
public static void loadConnection() {
	String url="jdbc:mysql://localhost:3306/java";
	String root="root";
	String pass="root";
	try {
		con = DriverManager.getConnection(url, root, pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}