package com.schoolmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.enitities.CourseClass;

public interface CourseClassRepo extends JpaRepository<CourseClass, Long> {

}
