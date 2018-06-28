package com.ems.service;

import java.util.List;

import com.ems.dto.JobTypeDto;

public interface IJobTypeService {
	
	List<JobTypeDto> getAllJobType();
	String deleteJobType(int job_id);
	JobTypeDto addNewJob(JobTypeDto newDto);
	
}
