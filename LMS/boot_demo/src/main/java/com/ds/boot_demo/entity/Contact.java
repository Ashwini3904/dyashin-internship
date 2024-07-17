package com.ds.boot_demo.entity;

import jakarta.persistence.CascadeType;

//import java.time.LocalDate;
//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String contactType;
	private String contactNumber;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EmployeePrimaryInfo primaryInfo;
}
