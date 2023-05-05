package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://pildevmysql01:3306/IAMUAT", "CSSUPPORT" , "C5su40rt@Dev");
		
		Statement statement= connection.createStatement();
		
		ResultSet result=statement.executeQuery("select USERID,FIRSTNAME,LASTNAME from IAM_AGENT where USERID in ('INNARMAN','INGOUMUT')");
		
		while(result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
		}
		
		
		
		 
		
		
		
		
		
		
		/*
		 * Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * Connection connection=DriverManager.getConnection(
		 * "jdbc:mysql://pildevmysql01:3306/IAMUAT", "CSSUPPORT" , "C5su40rt@Dev");
		 * 
		 * Statement statement=connection.createStatement();
		 * 
		 * ResultSet result=statement.
		 * executeQuery("select USERID,FIRSTNAME,LASTNAME from IAM_AGENT where USERID in ('INNARMAN','INGOUMUT')"
		 * );
		 */
		         
	
	}
}

