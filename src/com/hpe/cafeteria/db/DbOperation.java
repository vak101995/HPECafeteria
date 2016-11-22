package com.hpe.cafeteria.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DbOperation {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "root";
	static final String PASS = "password";

	Connection conn = null;
	Statement stmt = null;

	// String db_name = "";
	// String db_age = "";

	public String updateOrder(CafeteriaBean ur) {
		String status = "not done";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to daturase...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Statement created...");
			String sql;
			// System.out.println("36:"+ur.getUserName());
			sql = "UPDATE cafeteria SET Status='" + ur.getStatus() + "' WHERE Order_no='" + ur.getOrderNo() + "'";
			int s = stmt.executeUpdate(sql);
			if (s > 0) {

				status = "done";
			} else
				status = "not done";

		}

		catch (SQLException se) {

			se.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println("55" + status);
		return status;

	}

	public String processOrder(CafeteriaBean ur) {
		String status = "not done";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to daturase...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Statement created...");
			String sql;
			// System.out.println("36:"+ur.getUserName());
			
			sql = "SELECT Emp_id,Name,Food,Quantity,Order_no FROM cafeteria WHERE Order_no='"+ ur.getOrderNo() +"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ur.setEmpid(Integer.parseInt(rs.getString("Emp_id")));
				ur.seteName(rs.getString("Name"));
				ur.setFood(rs.getString("Food"));
				ur.setQuantity(Integer.parseInt(rs.getString("Quantity")));
				ur.setOrderNo(Integer.parseInt(rs.getString("Order_no")));
				status = "done";
			}

		}

		catch (SQLException se) {

			se.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println("55" + status);
		return status;
	}

	public String makeOrderEntry(CafeteriaBean ab) {
		String status = "not done";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Statement created...");
			String sql;
			// System.out.println("36:"+ab.getUserName());
			//INSERT INTO cafeteria(Emp_id,Name,Food,Quantity) values(6,'amrit','momo',5
			sql = "INSERT INTO cafeteria(Emp_id,Name,Food,Quantity) values(" +ab.getEmpid()+","+"'" + ab.geteName()+"'" +","+"'" +ab.getFood()+"'"+","
					+ ab.getQuantity() + ")";
			System.out.println(sql);
			int s = stmt.executeUpdate(sql);
			System.out.println("118:status is: "+s);
			if (s > 0) {
				status = "done";

			} else {

				status = "not done";
			}

		}

		catch (SQLException se) {

			se.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println("135" + status);
		return status;
	}

}
