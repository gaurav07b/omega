package com.ems.service;

import java.util.List;

import com.ems.dto.ProjectDto;

public interface IProjectService {

	List<ProjectDto> getAllProject();
	String deleteProject(int proj_id);
	ProjectDto findOneProject(int proj_id);
	ProjectDto addNewProject(ProjectDto newDto);
	
}
