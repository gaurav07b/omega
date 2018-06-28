package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.ProjectDto;
import com.ems.response.ResponseData;
import com.ems.service.IProjectService;

@RestController("projController")
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private IProjectService projService;

//******************************************getAll*********************************************
	@RequestMapping(method = RequestMethod.GET)
	public ResponseData getAllProjects(){
		List<ProjectDto> pDto = projService.getAllProject();
		ResponseData reponseData = new ResponseData("200", "Following Data Found", pDto);

		return reponseData;
	}
	
//******************************************getOne*********************************************
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseData findOne(@PathVariable(value = "id") int pId) {

		ProjectDto pDto = projService.findOneProject(pId);
		ResponseData responseData = new ResponseData("200", "Following Data Found", pDto);
		return responseData;

	}
	
//*******************************************addNew*********************************************
	@RequestMapping(method = RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseData addNew(@RequestBody ProjectDto newDto) {
		
		newDto = projService.addNewProject(newDto);
		ResponseData responseData = new ResponseData("200", "Added successfuly", newDto);
		return responseData;
		
	}

//******************************************deleteOne********************************************	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public String deleteProj(@PathVariable("id") int pId) {
		
		projService.deleteProject(pId);
		return "Deletion Successful";
		
	}


}
