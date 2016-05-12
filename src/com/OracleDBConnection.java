package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDBConnection {
	static Connection connection;
    ResultSet resultSet;
    
	public static boolean connect(String host, String username, String password) throws SQLException, ClassNotFoundException{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        connection = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":XE", username, password);
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String args[])
	{
		try {
			if(connect("localhost:1521","student","student"))
			{
				System.out.println("Connection successful");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
