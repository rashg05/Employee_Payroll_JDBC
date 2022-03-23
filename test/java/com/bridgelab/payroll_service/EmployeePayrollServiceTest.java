package com.bridgelab.payroll_service;

import java.util.List;
import org.junit.Test;

import static com.bridgelab.payroll_service.EmployeePayrollService.IOService.DB_IO;
import static org.junit.Assert.assertEquals;

public class EmployeePayrollServiceTest {

	@Test
	public void givenEmployeePayrollInDB_whenRetrived_shouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
		assertEquals(3, employeePayrollData.size());
	}
}
