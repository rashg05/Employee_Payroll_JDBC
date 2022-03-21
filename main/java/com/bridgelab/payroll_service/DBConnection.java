package com.bridgelab.payroll_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/payroll_service";
		String username = "root";
		String password = "Rash@123";
		Connection connection = null;
		try {

			System.out.println("Connecting to databse: " +dbURL);
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
