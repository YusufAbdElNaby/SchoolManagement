package com.schoolmanagement.service;

import java.util.List;

import com.schoolmanagement.dto.CourseDto;
import com.schoolmanagement.dto.CourseSimpleDto;

public interface CourseService {

	public List<CourseSimpleDto> listAllSimpleCourses();

	public List<CourseDto> listAllOpendCourses();

	public CourseDto getCourseById(Long id);

	public CourseSimpleDto getSimpleCourseById(Long id);
}
