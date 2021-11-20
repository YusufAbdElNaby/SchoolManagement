package com.schoolmanagement.dto;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentRegistrationRequestDto {

	@NotNull
	private Long classId;

	@NotNull
	private Long studentId;
}
