package com.schoolmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.schoolmanagement.enitities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	@EntityGraph(attributePaths = { "clazz" })
	@Query("SELECT s FROM Student s where s.id =?1 ")
	public Student getStudentById(Long id);
	
	@EntityGraph(attributePaths = { "clazz" })
	@Query("SELECT s FROM Student s ")
	public List<Student> ListAllStudents();
}
