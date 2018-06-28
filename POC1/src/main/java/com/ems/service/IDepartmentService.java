package com.ems.service;

import java.util.List;

import com.ems.dto.DepartmentsDto;

public interface IDepartmentService {
	
	List<DepartmentsDto> getAllDept();
	String deleteOneDept(int dept_id);
	DepartmentsDto findOneDept(int dept_id);
	DepartmentsDto addNewDept(DepartmentsDto newDto);

}
