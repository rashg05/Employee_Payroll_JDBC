package com.bridgelab.payroll_service;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeePayrollDBService {
	Connection connection = null;
	Statement statement = null;
	Scanner scanner = new Scanner(System.in);

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String username = "root";
		String password = "Rash@123";
//		Connection connection;
		connection = DriverManager.getConnection(dbURL,username,password);
		System.out.println(" Database connection is successfull");
		return connection;
	}

	public List<EmployeePayrollData> readData() {
        String query="SELECT * from employee_payroll;";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id,name,salary,startDate));
            }
            System.out.println(employeePayrollList);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
	public static void main(String[] args) throws ParseException {
		EmployeePayrollDBService employeePayrollService=new EmployeePayrollDBService();
		employeePayrollService.readData();
	}
}
