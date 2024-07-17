package com.ds.boot_demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationaDetailsDto {
	
	
    private String educationType;
	
	private Integer yearOfPassing;
	
	private Double percentage;
	
	private String university;
	
	private String institute;
	
	private String specialization;
	
	private String state;
}
