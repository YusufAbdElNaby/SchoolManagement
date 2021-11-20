package com.schoolmanagement.service;

import java.util.List;

import com.schoolmanagement.dto.StudentDto;
import com.schoolmanagement.enitities.Class;

public interface Studentervice {

	public Boolean registrStudentToClass(Long studentId, Class clazz);
	
	public StudentDto getStudentById(Long studentId);

	public List<StudentDto> listAllStudents();

}
