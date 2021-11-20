package com.schoolmanagement.enitities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course_class")
@Data
public class CourseClass {

	public CourseClass() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @ManyToOne(targetEntity = Class.class)
    @JoinColumn(name = "class_id", nullable = false)
    private Class clazz;
    
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

}
