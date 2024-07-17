package com.ds.boot_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationalDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String educationType;
	
	private Integer yearOfPassing;
	
	private Double percentage;
	
	private String university;
	
	private String institute;
	
	private String specialization;
	
	private String state;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private EmployeePrimaryInfo primaryinfo;
}
