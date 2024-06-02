package com.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://127.0.0.1:3306/defaultdb";
		String uname = "root";
		String pass = "Akshay-1029";
		
		String service_name = "Lab Test";
		int service_fee = 100;
		String created_by = "Admin";
		String query = "insert into service(service_name,service_fee,created_by,modified_by) values (?,?,?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, service_name);
		ps.setInt(2, service_fee);
		ps.setString(3, created_by);
		ps.setString(4, created_by);
		
		int count = ps.executeUpdate();
		
		System.out.println(count+" row/s affected");

	}

}
