package com.project.basics;

import java.sql.*;

import com.project.jdbc.DatabaseConfig;

public class SelectStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		DatabaseConfig dbConfig = new DatabaseConfig();

		String url = dbConfig.getProperty("db.url");
		String uname = dbConfig.getProperty("db.uname");
		String pass = dbConfig.getProperty("db.pass");
		String query = "select * from patient";
		String query1 = "select * from patient where p_id=297";

		int hstaff_id = 1004;
		int age = 24;
		String query2 = "select * from patient where hstaff_id=" + hstaff_id + " and age=" + age;

		String address = "Blacksburg";
		String query3 = "select * from patient where hstaff_id=? and address=?";

		Class.forName(dbConfig.getProperty("db.driver")); // Loads the class
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();

		// Query for fetching multiple rows
		ResultSet rs = st.executeQuery(query);
		System.out.println("Query for fetching multiple rows");
		while (rs.next())
			System.out.println(rs.getString("fname") + "		" + rs.getString("lname") + "		"
					+ rs.getString("email") + "		" + rs.getString("age"));

		// Query for fetching single row

		rs = st.executeQuery(query1);
		System.out.println("Query for fetching single row");
		rs.next();
		System.out.println(rs.getString("fname") + "		" + rs.getString("lname") + "		"
				+ rs.getString("email") + "		" + rs.getString("age"));

		// Query for fetching rows using variable in where clause
		rs = st.executeQuery(query2);
		System.out.println("Query for fetching rows using variable in where clause");
		while (rs.next())
			System.out.println(rs.getString("fname") + "		" + rs.getString("lname") + "		"
					+ rs.getString("email") + "		" + rs.getString("age"));

		// Prepared Statement Example

		PreparedStatement ps = con.prepareStatement(query3);
		ps.setInt(1, hstaff_id);
		ps.setString(2, address);
		rs = ps.executeQuery();
		System.out.println("Prepared Statement Example");
		while (rs.next())
			System.out.println(rs.getString("fname") + "		" + rs.getString("lname") + "		"
					+ rs.getString("email") + "		" + rs.getString("age"));

		rs.close();
		st.close();
		con.close();
	}

}
