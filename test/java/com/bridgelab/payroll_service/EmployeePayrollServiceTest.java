package com.bridgelab.payroll_service;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static com.bridgelab.payroll_service.EmployeePayrollService.IOService.DB_IO;
//import static org.junit.Assert.assertEquals;

public class EmployeePayrollServiceTest {

//	@Test
//	public void givenEmployeePayrollInDB_whenRetrived_shouldMatchEmployeeCount() {
//		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
//		List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
//		assertEquals(3, employeePayrollData.size());
//	}
	
	 @Test
	    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
	        employeePayrollService.updateEmployeeSalary("Terisa", 4000000.0);
	        boolean result = employeePayrollService.checkEmployeeInSyncWithDB("Terisa");
	        Assert.assertTrue(result);
	    }
	 
	 @Test
	    public void givenEmployeePayrollDB_AbilityToRetrievAllTheEmployees_JoinedInParticularDataRanga() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        List<EmployeePayrollData> employeePayrollData=employeePayrollService.readEmployeePayrollData(DB_IO);
	        List<EmployeePayrollData> employeePayrollDataByGivenDataRange = employeePayrollService.getEmployeePayrollDataByGivenDataRange(LocalDate.of(2018, 01, 01), LocalDate.now());
	        Assert.assertEquals(employeePayrollDataByGivenDataRange.get(0),employeePayrollData.get(0));
	    }
	 @Test
	    public void givenEmployeePayrollData_ShouldReturnTheAverageOfTheSalariesOfGender() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        double employeePayrollData1 = employeePayrollService.performVariousOperations("AVG", "M");
	        Assert.assertEquals(employeePayrollData1,2000000.0,0.0);
	    }

	    @Test
	    public void givenEmployeePayrollData_ShouldReturnTheSumOfTheSalariesOfGender() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        double employeePayrollData1 = employeePayrollService.performVariousOperations("SUM", "M");
	        Assert.assertEquals(employeePayrollData1,4000000.0,0.0);
	    }

	    @Test
	    public void givenEmployeePayrollData_ShouldReturnTheMaxOfTheSalariesOfGender() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        double employeePayrollData1 = employeePayrollService.performVariousOperations("MAX", "M");
	        Assert.assertEquals(employeePayrollData1,3000000.0,0.0);
	    }

	    @Test
	    public void givenEmployeePayrollData_ShouldReturnTheMinOfTheSalariesOfGender() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        double employeePayrollData1 = employeePayrollService.performVariousOperations("MIN", "M");
	        Assert.assertEquals(employeePayrollData1,1000000.0,0.0);
	    }

	    @Test
	    public void givenEmployeePayrollData_ShouldReturnTheCountOfTheEmployeeByGender() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        double employeePayrollData1 = employeePayrollService.performVariousOperations("COUNT", "M");
	        Assert.assertEquals(employeePayrollData1,2,0.0);
	    }
	 
}
