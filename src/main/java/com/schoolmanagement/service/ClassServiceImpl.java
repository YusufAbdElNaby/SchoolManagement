package com.schoolmanagement.service;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.dto.AssigningClassAndToCourseAndTeacherRequestDto;
import com.schoolmanagement.dto.ClassDto;
import com.schoolmanagement.dto.ClassRequestDto;
import com.schoolmanagement.dto.CourseClassDto;
import com.schoolmanagement.dto.StudentRegistrationRequestDto;
import com.schoolmanagement.dto.TeacherDto;
import com.schoolmanagement.enitities.Class;
import com.schoolmanagement.enitities.Course;
import com.schoolmanagement.enitities.CourseClass;
import com.schoolmanagement.enitities.Teacher;
import com.schoolmanagement.repo.ClassRepo;
import com.schoolmanagement.repo.CourseClassRepo;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepo classRepo;

	@Autowired
	private CourseClassRepo courseClassRepo;

	@Autowired
	private CourseService courseService;
	

	@Autowired
	private Studentervice studentervice;

	@Override
	public ClassDto addNewClass(ClassRequestDto classRequestDto) {
		com.schoolmanagement.enitities.Class clazz = new com.schoolmanagement.enitities.Class();
		clazz.setName(classRequestDto.getName());
		clazz = classRepo.save(clazz);
		ClassDto result = new ClassDto();
		result.setId(clazz.getId());
		result.setName(clazz.getName());
		return result;
	}

	@Override
	public CourseClassDto assignClassAndToCourseAndTeacherRequest(
			AssigningClassAndToCourseAndTeacherRequestDto assigningClassAndToCourseAndTeacherRequestDto) {
		CourseClass courseClass = new CourseClass();
		courseClass.setClazz(new Class(assigningClassAndToCourseAndTeacherRequestDto.getClassId()));
		courseClass.setCourse(new Course(assigningClassAndToCourseAndTeacherRequestDto.getCourseId()));
		courseClass.setTeacher(new Teacher(assigningClassAndToCourseAndTeacherRequestDto.getTeacherId()));
		courseClass = courseClassRepo.save(courseClass);

		CourseClassDto courseClassDto = new CourseClassDto();
		courseClassDto.setId(courseClass.getId());
		if (!Objects.isNull(courseClass.getClazz())) {
			ClassDto clazz = new ClassDto(courseClass.getClazz().getId(), courseClass.getClazz().getName());
			courseClassDto.setClazz(clazz);
		}

		if (!Objects.isNull(courseClass.getTeacher())) {
			TeacherDto teacher = new TeacherDto(courseClass.getTeacher().getId(), courseClass.getTeacher().getName());
			courseClassDto.setTeacher(teacher);
		}

		if (!Objects.isNull(courseClass.getCourse())) {
			courseClassDto.setCourseSimpleDto(courseService.getSimpleCourseById(courseClass.getCourse().getId()));
		}
		return courseClassDto;
	}

	@Override
	public Boolean close(Long id) {
        Class clazz = classRepo.getById(id);
        if(Objects.isNull(clazz)) {
        	return false;
        }
        clazz.setClosed(true);
        classRepo.save(clazz);
		return true;
	}

	@Override
	public Boolean registrStudent(@Valid StudentRegistrationRequestDto studentRegistrationRequestDto) {
		Class clazz = classRepo.getById(studentRegistrationRequestDto.getClassId());
        if(Objects.isNull(clazz)) {
        	return false;
        }
        clazz.setClosed(true);
        classRepo.save(clazz);
		return studentervice.registrStudentToClass(studentRegistrationRequestDto.getStudentId(), clazz);
	}

}
