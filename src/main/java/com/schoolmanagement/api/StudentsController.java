package com.schoolmanagement.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.dto.StudentDto;
import com.schoolmanagement.service.Studentervice;

@RestController
@RequestMapping("/students")
public class StudentsController {

	private Studentervice studentervice;

	public StudentsController(Studentervice studentervice) {

		this.studentervice = studentervice;
	}

	@GetMapping
	public ResponseEntity<List<StudentDto>> listAllStudents() {

		return new ResponseEntity<>(studentervice.listAllStudents(), HttpStatus.OK);
	}
	

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDto> getStudentByID(@PathVariable Long id) {

		return new ResponseEntity<>(studentervice.getStudentById(id), HttpStatus.OK);
	}

}
