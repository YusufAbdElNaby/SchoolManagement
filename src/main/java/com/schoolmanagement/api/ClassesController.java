package com.schoolmanagement.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.dto.AssigningClassAndToCourseAndTeacherRequestDto;
import com.schoolmanagement.dto.ClassDto;
import com.schoolmanagement.dto.ClassRequestDto;
import com.schoolmanagement.dto.CourseClassDto;
import com.schoolmanagement.dto.StudentRegistrationRequestDto;
import com.schoolmanagement.service.ClassService;

@RestController
@RequestMapping("/classes")
public class ClassesController {

	private ClassService classService;

	public ClassesController(ClassService classService) {
		this.classService = classService;
	}

	@PostMapping
	public ResponseEntity<ClassDto> addClass(@Valid @RequestBody ClassRequestDto classRequestDto) {

		return new ResponseEntity<>(classService.addNewClass(classRequestDto), HttpStatus.CREATED);
	}

	@PostMapping(value = "/assign-teacher-course")
	public ResponseEntity<CourseClassDto> AssignClassAndToCourseAndTeacher(
			@Valid @RequestBody AssigningClassAndToCourseAndTeacherRequestDto assigningClassAndToCourseAndTeacherRequestDto) {

		return new ResponseEntity<>(
				classService.assignClassAndToCourseAndTeacherRequest(assigningClassAndToCourseAndTeacherRequestDto),
				HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/close")
	public ResponseEntity<Boolean> AssignClassAndToCourseAndTeacher(@PathVariable Long id) {

		return new ResponseEntity<>(
				classService.close(id),
				HttpStatus.OK);
	}

	@PostMapping(value = "/student-registration")
	public ResponseEntity<Boolean> registrStudent(
			@Valid @RequestBody StudentRegistrationRequestDto studentRegistrationRequestDto) {

		return new ResponseEntity<>(
				classService.registrStudent(studentRegistrationRequestDto),
				HttpStatus.OK);
	}
}
