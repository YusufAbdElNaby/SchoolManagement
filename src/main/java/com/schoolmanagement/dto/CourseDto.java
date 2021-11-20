package com.schoolmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CourseDto {
	
	private Long id;

	private String name;

	private TermDto term; 
	
	private List<CourseClassDto> classes = new ArrayList<CourseClassDto>();
	
	private Boolean opened;


}
