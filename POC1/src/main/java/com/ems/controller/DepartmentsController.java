package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.DepartmentsDto;
import com.ems.response.ResponseData;
import com.ems.service.IDepartmentService;

@RestController("deptController")
@RequestMapping("/department")
public class DepartmentsController {
	
	@Autowired IDepartmentService deptService;

//******************************************getAll*********************************************
	@RequestMapping(method = RequestMethod.GET)
	public ResponseData getDept() {
		
		List<DepartmentsDto> dept = deptService.getAllDept();
		ResponseData resp = new ResponseData("200", "List of Departments", dept);
		return resp;
		
	}

//******************************************getOne**********************************************	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseData findOne(@PathVariable(value = "id") int dId) {

		DepartmentsDto ddto = deptService.findOneDept(dId);
		ResponseData responseData = new ResponseData("200", "Following Department Found", ddto);
		return responseData;
	}

//******************************************addNew**********************************************
	@RequestMapping(method = RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseData addNew(@RequestBody DepartmentsDto newDto) {
		
		newDto = deptService.addNewDept(newDto);
		ResponseData responseData = new ResponseData("200", "Added successfuly", newDto);
		return responseData;
		
	}
	
//******************************************deleteOne**********************************************		
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public String deleteDept(@PathVariable("id") int dId) {
		
		deptService.deleteOneDept(dId);
		return "Deletion Successful";	
	}

}
