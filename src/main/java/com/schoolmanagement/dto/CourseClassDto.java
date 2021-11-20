package com.schoolmanagement.dto;

import lombok.Data;

@Data
public class CourseClassDto {

	private Long id;

	private ClassDto clazz;

	private CourseSimpleDto courseSimpleDto;

	private TeacherDto teacher;

}
