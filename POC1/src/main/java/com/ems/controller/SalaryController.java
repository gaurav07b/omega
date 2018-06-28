package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.SalaryDto;
import com.ems.response.ResponseData;
import com.ems.service.ISalaryService;

@RestController("salaryController")
@RequestMapping("/salary")
public class SalaryController {
	
	@Autowired
	private ISalaryService salService;

//******************************************getAll*********************************************
	@RequestMapping(method = RequestMethod.GET)
	public ResponseData getEmps() {

		List<SalaryDto> sal = salService.getAllSalary();
		ResponseData reponseData = new ResponseData("200", "Following Data Found", sal);
		return reponseData;
	}

//******************************************addNew**********************************************
	@RequestMapping(method = RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseData addNew(@RequestBody SalaryDto newDto) {
		
		newDto = salService.addNewSal(newDto);
		ResponseData responseData = new ResponseData("200", "Added successfuly", newDto);
		return responseData;
		
	}

//******************************************deleteOne**********************************************	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") int salId) {
		
		salService.deleteOneSal(salId);
		return "Deletion Successful";
		
	}

}
