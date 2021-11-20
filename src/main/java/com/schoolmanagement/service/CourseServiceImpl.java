package com.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.dto.ClassDto;
import com.schoolmanagement.dto.CourseClassDto;
import com.schoolmanagement.dto.CourseDto;
import com.schoolmanagement.dto.CourseSimpleDto;
import com.schoolmanagement.dto.TeacherDto;
import com.schoolmanagement.dto.TermDto;
import com.schoolmanagement.enitities.Course;
import com.schoolmanagement.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public List<CourseSimpleDto> listAllSimpleCourses() {
		List<Course> courses = courseRepo.listAllSimpleCourse();
		List<CourseSimpleDto> result = new ArrayList<CourseSimpleDto>();

		courses.forEach(course -> {
			CourseSimpleDto courseSimpleDto = mapSimpleCourse(course);
			result.add(courseSimpleDto);
		});
		return result;
	}

	private CourseSimpleDto mapSimpleCourse(Course course) {
		CourseSimpleDto courseSimpleDto = new CourseSimpleDto();
		courseSimpleDto.setId(course.getId());
		courseSimpleDto.setName(course.getName());
		courseSimpleDto.setOpened(course.getOpened());

		if (!Objects.isNull(course.getTerm())) {
			courseSimpleDto.setTerm(
					new TermDto(course.getTerm().getId(), course.getTerm().getName(), course.getTerm().getYear()));
		}
		return courseSimpleDto;
	}

	@Override
	public List<CourseDto> listAllOpendCourses() {
		List<Course> courses = courseRepo.listOpenedCourse();
		List<CourseDto> result = new ArrayList<CourseDto>();
		courses.forEach(course -> {
			CourseDto courseSimpleDto = mapCourse(course);
			result.add(courseSimpleDto);
		});
		return result;
	}

	private CourseDto mapCourse(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setId(course.getId());
		courseDto.setName(course.getName());
		courseDto.setOpened(course.getOpened());
		List<CourseClassDto> classes = new ArrayList<CourseClassDto>();
		courseDto.setClasses(classes);
		if (!Objects.isNull(course.getTerm())) {
			courseDto.setTerm(
					new TermDto(course.getTerm().getId(), course.getTerm().getName(), course.getTerm().getYear()));
		}

		if (!Objects.isNull(course.getClasses())) {
			course.getClasses().forEach(courseClass -> {
				CourseClassDto courseClassDto = new CourseClassDto();
				classes.add(courseClassDto);
				courseClassDto.setId(courseClass.getId());
				if (!Objects.isNull(courseClass.getClazz())) {
					ClassDto clazz = new ClassDto(courseClass.getClazz().getId(), courseClass.getClazz().getName());
					courseClassDto.setClazz(clazz);
				}

				if (!Objects.isNull(courseClass.getTeacher())) {
					TeacherDto teacher = new TeacherDto(courseClass.getTeacher().getId(),
							courseClass.getTeacher().getName());
					courseClassDto.setTeacher(teacher);
				}

			});
			courseDto.setTerm(
					new TermDto(course.getTerm().getId(), course.getTerm().getName(), course.getTerm().getYear()));
		}
		return courseDto;
	}

	@Override
	public CourseDto getCourseById(Long id) {
		Course course = courseRepo.getCourseById(id);
		return mapCourse(course);
	}

	@Override
	public CourseSimpleDto getSimpleCourseById(Long id) {
		Course course = courseRepo.getCourseById(id);
		return mapSimpleCourse(course);
	}
}
