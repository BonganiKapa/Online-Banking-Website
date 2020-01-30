package system.onlinebanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.onlinebanking.bean.LoginBean;

public class LoginDAO {
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
		boolean status = false;
		
		Class.forName("org.h2.Driver");
		
		try(Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				//SQL Statment for login 
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM client_details WHERE email = ? AND password = ?")){
			ps.setString(1, loginBean.getEmail());
			ps.setString(2, loginBean.getPassword());
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		}
		catch(SQLException ex) {
			//process SQL exception
			printSQLException(ex);
		}
		
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e: ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while(t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
				
			}
		}
		
	}
}
