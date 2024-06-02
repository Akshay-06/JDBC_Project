package com.project.basics;

import java.sql.Connection;

import com.project.jdbc.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatabaseConfig dbConfig = new DatabaseConfig();

		Connection con = dbConfig.connectToDatabase();
		PreparedStatement ps = null;

		String service_name = "Lab Test";
		int service_fee = 100;
		String created_by = "Admin";
		String query = "insert into service(service_name,service_fee,created_by,modified_by) values (?,?,?,?)";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, service_name);
			ps.setInt(2, service_fee);
			ps.setString(3, created_by);
			ps.setString(4, created_by);

			int count = ps.executeUpdate();

			System.out.println(count + " row/s affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
