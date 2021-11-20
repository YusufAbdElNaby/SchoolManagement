package com.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.dto.ClassDto;
import com.schoolmanagement.dto.StudentDto;
import com.schoolmanagement.enitities.Class;
import com.schoolmanagement.enitities.Student;
import com.schoolmanagement.repo.StudentRepo;

@Service
public class StudentServiceImpl implements Studentervice {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Boolean registrStudentToClass(Long studentId, Class clazz) {
		Student student = studentRepo.getStudentById(studentId);
		if (Objects.isNull(student)) {
			return false;
		}
		student.setClazz(clazz);
		studentRepo.save(student);
		return true;
	}

	@Override
	public StudentDto getStudentById(Long studentId) {
		Student student = studentRepo.getStudentById(studentId);
		StudentDto result = mapStudent(student);
		return result;
	}

	private StudentDto mapStudent(Student student) {
		StudentDto result = new StudentDto();
		result.setId(student.getId());
		result.setName(student.getName());
		if (Objects.nonNull(student.getClazz())) {
			ClassDto clazz = new ClassDto(student.getClazz().getId(), student.getClazz().getName());
			result.setClazz(clazz);

		}
		return result;
	}

	@Override
	public List<StudentDto> listAllStudents() {
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		List<Student> students = studentRepo.ListAllStudents();
		students.forEach(student -> {
			studentDtos.add(mapStudent(student));
		});
		return studentDtos;
	}

}
