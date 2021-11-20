package com.schoolmanagement.dto;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssigningClassAndToCourseAndTeacherRequestDto {

	@NotNull
	private Long classId;

	@NotNull
	private Long courseId;

	@NotNull
	private Long teacherId;
}
