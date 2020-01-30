package system.onlinebanking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import system.onlinebanking.model.DatabaseUtil;

//import javax.servlet.*;
public class MyListener implements ServletContextListener {

	//@Override
	public void contextInitialized(ServletContextEvent sce) {
		int status = 0;
		Connection con = null;
		
		try {
			con = DatabaseUtil.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from CLIENT_DETAILS");
			
			try {
				status = ps.executeUpdate();
			}
			
			catch(Exception ex) {
				ex.printStackTrace();
				status =2;
				System.out.println("My status is 11111 " + status);
			}
			
			if (status == 0) {
				System.out.println("Your Table Name Already Exist " + status);
			}
			
			else if (status == 2) {
				System.out.println("Else if part table doesn't exist new table has been created " + status);
				PreparedStatement ps1 = con.prepareStatement("CREATE SEQUENCE MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 1");
				ps1.executeUpdate();
				
				PreparedStatement ps2 = con.prepareStatement("CREATE TABLE CLIENT_DETAILS(ACCOUNT NUMBER, CLIENT_NAME VARCHAR(100), PASSWORD VARCHAR(100), REPASSWORD VARCHAR(100), ADDRESS VARCHAR(100), PHONE_NUMBER VARCHAR(100)");
				ps2.executeUpdate();
			}
			else {
				System.out.println("Else Part " + status);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application Rejected");	
	}	
}
