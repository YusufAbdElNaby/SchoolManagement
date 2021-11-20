package com.schoolmanagement.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.dto.CourseDto;
import com.schoolmanagement.dto.CourseSimpleDto;
import com.schoolmanagement.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	private CourseService courseService;

	public CoursesController(CourseService courseService) {

		this.courseService = courseService;
	}

	@GetMapping
	public ResponseEntity<List<CourseSimpleDto>> listAllSimpleCourses() {

		return new ResponseEntity<>(courseService.listAllSimpleCourses(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/available")
	public ResponseEntity<List<CourseDto>> listAllOpendCourses() {

		return new ResponseEntity<>(courseService.listAllOpendCourses(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseDto> getCourseByID(@PathVariable Long id) {

		return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
	}

}
