package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.IEmployeeService;
import com.ems.dto.EmployeesDto;
import com.ems.response.ResponseData;

@RestController("empController")
@RequestMapping("/employee")
public class EmployeesController {

	@Autowired
	private IEmployeeService empService;
	
//******************************************getAll*********************************************
	@RequestMapping(method = RequestMethod.GET)
	public ResponseData getEmps() {

		List<EmployeesDto> emps = empService.getAllEmployees();
		ResponseData reponseData = new ResponseData("200", "Following Data Found", emps);

		return reponseData;
	}

//******************************************getOne**********************************************
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseData findOne(@PathVariable(value = "id") int eId) {

		EmployeesDto edto = empService.findOneEmp(eId);
		ResponseData responseData = new ResponseData("200", "Following Data Found", edto);
		return responseData;

	}
	
//******************************************addNew**********************************************
	@RequestMapping(method = RequestMethod.POST)
	public ResponseData addNew(@RequestBody EmployeesDto newDto) {
		
		newDto = empService.addNewEmp(newDto);
		ResponseData responseData = new ResponseData("200", "Added successfuly", newDto);
		return responseData;
		
	}
	
//******************************************updateEmp-(id in input)**********************************************	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseData  updateEmpBody(@RequestBody EmployeesDto empDto) {
			
		empDto=empService.updateEmp(empDto);
		ResponseData status=new ResponseData("200","Successfuylly Updated!!",empDto);
		return status;	
	}

//******************************************updateEmp-{id in url}*******************************************
	@RequestMapping(value= "/{id}", method=RequestMethod.PUT)
	public ResponseData updateEmpURL(@PathVariable(value = "id") int eId, @RequestBody EmployeesDto empDto) {
		
		EmployeesDto edto = empService.updateEmpURL(eId, empDto);
		ResponseData responseData = new ResponseData("200", "Following Data Found", edto);
		return responseData;
	}
	
//******************************************deleteOne**********************************************	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") int eId) {
		
		empService.deleteOneEmp(eId);
		return "Deletion Successful of eId= "+eId;		
	}
	
//*****************************************deleteAll***********************************************
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteAll() {
		
		return "Deleted All Employees";
		
	}
}
