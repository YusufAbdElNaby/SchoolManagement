package com.schoolmanagement.dto;

import lombok.Data;

@Data
public class StudentDto {

	private Long id;

	private String name;
	
	private ClassDto clazz;

}
