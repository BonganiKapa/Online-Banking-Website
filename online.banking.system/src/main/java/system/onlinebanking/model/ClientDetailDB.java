package system.onlinebanking.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import system.onlinebanking.enums.Gender;

public class ClientDetailDB {
	
	String client = null;
	
	public String newClient(String firstName, String lastName, String idNum, String address,
			String phone, String email, String password, String repassword, Gender gender) {
		
		DBConnector dbc = new DBConnector();
		Connection connect = dbc.getConnection();
		
		try {
			Statement statement = connect.createStatement();
			statement.executeQuery("insert into CLIENT_DETAIL (firstName, lastName, idNum, address, phone, email, password, gender) values ('"+firstName+"','"+lastName+"','"+idNum+"','"+address+"','"+phone+"','"+email+"','"+password+"','"+gender+"')");
			client = "Client Details Saved"; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
	}
}
