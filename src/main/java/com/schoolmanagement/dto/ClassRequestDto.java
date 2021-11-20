package com.schoolmanagement.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassRequestDto {

	@NotEmpty
	private String name;
}
