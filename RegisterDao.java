package com.lti.training.servlet2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {
	PreparedStatement stmt=null;
	ResultSet rs;
	public boolean check(String name,String email, String username,String password) {
	
		 
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establishing Connection with the database
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="hr";
			String pass="hr";
			
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Connected successfully...");
			String str ="insert into TBL_REG values(?,?,?,?) ";
		    stmt=conn.prepareStatement(str);
    
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			
			stmt.setString(3,username);
			stmt.setString(4,password);
			stmt.executeUpdate();
			
			
			return true;
		 
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
}
