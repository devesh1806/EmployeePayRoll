package com.employeepayrolltest;

import java.util.Arrays;

import org.junit.Test;

import com.employeepayroll.EmployeePayrollData;
import com.employeepayroll.EmployeePayrollService;
import com.employeepayroll.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEntries() {
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(1, "Devesh", 10000.0),
				new EmployeePayrollData(2, "Deepak", 100000.0),
				new EmployeePayrollData(3, "Vishal", 20000.0)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		
	}
}
