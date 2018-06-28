package com.ems.service;

import java.util.List;

import com.ems.dto.EmployeesDto;

public interface IEmployeeService {
	
	List<EmployeesDto> getAllEmployees();
	String deleteOneEmp(int emp_id);
	EmployeesDto findOneEmp(int emp_id);
	EmployeesDto addNewEmp(EmployeesDto newDto);
	EmployeesDto updateEmp(EmployeesDto empDto);
	void deleteAllEmp();
	EmployeesDto updateEmpURL(int eId, EmployeesDto empDto);
}
