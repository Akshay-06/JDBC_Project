package com.project.basics;

import java.sql.*;

import com.project.jdbc.DatabaseConfig;

public class SelectStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatabaseConfig dbConfig = new DatabaseConfig();

		String query = "select * from patient";
		String query1 = "select * from patient where p_id=297";

		int hstaff_id = 1004;
		int age = 24;
		String query2 = "select * from patient where hstaff_id=" + hstaff_id + " and age=" + age;

		String address = "Blacksburg";
		String query3 = "select * from patient where hstaff_id=? and address=?";

		Connection con = dbConfig.connectToDatabase();
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			st = con.createStatement();

			// Query for fetching multiple rows
			rs = st.executeQuery(query);
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

			ps = con.prepareStatement(query3);
			ps.setInt(1, hstaff_id);
			ps.setString(2, address);
			rs = ps.executeQuery();
			System.out.println("Prepared Statement Example");
			while (rs.next())
				System.out.println(rs.getString("fname") + "		" + rs.getString("lname") + "		"
						+ rs.getString("email") + "		" + rs.getString("age"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
