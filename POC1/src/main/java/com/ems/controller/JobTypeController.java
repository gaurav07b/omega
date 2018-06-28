package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.JobTypeDto;
import com.ems.response.ResponseData;
import com.ems.service.JobServiceImpl;

@RestController("jobTypeController")
@RequestMapping("/jobType")
public class JobTypeController {
	
	@Autowired
	private JobServiceImpl jService;

//******************************************getAll*********************************************
	@RequestMapping(method = RequestMethod.GET)
	public ResponseData getAllJob() {
		List<JobTypeDto> jList = jService.getAllJobType();
		ResponseData resData = new ResponseData("200", "Following jobs found", jList);
		return resData;
		
	}

//******************************************deleteOne**********************************************	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removeJob(@PathVariable("id") int jobId) {
		
		jService.deleteJobType(jobId);
		return "Deleted successfully";
	}

//******************************************addNew**********************************************	
	@RequestMapping(method = RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseData addJob(@RequestBody JobTypeDto jDto) {
		
		jDto = jService.addNewJob(jDto);
		ResponseData resData = new ResponseData("200", "Successful", jDto);
		return resData;
		
	}

}
