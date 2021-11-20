package com.schoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSimpleDto {
	
	private Long id;

	private String name;

	private TermDto term; 
	
	private Boolean opened;


}
