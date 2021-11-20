package com.schoolmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.schoolmanagement.enitities.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

	@EntityGraph(attributePaths = { "term", "classes"})
	@Query("SELECT c FROM Course c  ")
	public List<Course> listAllSimpleCourse();
	
	@EntityGraph(attributePaths = { "term", "classes", "classes.clazz", "classes.teacher" })
	@Query("SELECT c FROM Course c where c.opened= true ")
	public List<Course> listOpenedCourse();
	
	@EntityGraph(attributePaths = { "term", "classes", "classes.clazz", "classes.teacher" })
	@Query("SELECT c FROM Course c where c.id =?1 ")
	public Course getCourseById(Long id);

}
