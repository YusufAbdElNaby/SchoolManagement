package com.schoolmanagement.service;

import javax.validation.Valid;

import com.schoolmanagement.dto.AssigningClassAndToCourseAndTeacherRequestDto;
import com.schoolmanagement.dto.ClassDto;
import com.schoolmanagement.dto.ClassRequestDto;
import com.schoolmanagement.dto.CourseClassDto;
import com.schoolmanagement.dto.StudentRegistrationRequestDto;

public interface ClassService {

	public ClassDto addNewClass(ClassRequestDto classRequestDto);

	public CourseClassDto assignClassAndToCourseAndTeacherRequest(
			AssigningClassAndToCourseAndTeacherRequestDto assigningClassAndToCourseAndTeacherRequestDto);

	public Boolean close(Long id);

	public Boolean registrStudent(@Valid StudentRegistrationRequestDto studentRegistrationRequestDto);

}
