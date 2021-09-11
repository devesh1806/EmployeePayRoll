package com.employeepayrolltest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.employeepayroll.EmployeePayrollData;
import com.employeepayroll.EmployeePayrollService;
import com.employeepayroll.EmployeePayrollService.IOService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeePayrollServiceTest {
	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEntries() {
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(1, "Devesh", 10000.85),
				new EmployeePayrollData(2, "Deepak", 100000.156),
				new EmployeePayrollData(3, "Vishal", 20000.8956)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
		
	}
	
	@Test
	public void givenEmployees_WhenReadFromFile_ShouldReturnExactSize() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entrie = employeePayrollService.readData(IOService.FILE_IO);
		Assert.assertEquals(3,entrie);
	}
}
