package com.schoolmanagement.enitities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {

	public Course() {
	}
	
	public Course(Long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = Term.class)
	@JoinColumn(name = "term_id", nullable = false)
	private Term term;

	@OneToMany(targetEntity = CourseClass.class, mappedBy = "course", fetch = FetchType.LAZY)
	private List<CourseClass> classes = new ArrayList<CourseClass>();
	
	@Column(name ="opened")
	private Boolean opened;

}
