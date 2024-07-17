package com.ds.boot_demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name="employee_secondary_info")
public class EmployeeSecondayInfo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	  @Column(name="Pan_No",unique=true)
      private String PanNo;
	  
	  @Column(name="Aadhar_No",unique=true)
  	  private String AadharNo;
	  
	  @Column(name="Father_Name")
  	  private String FatherName;
	  
	  @Column(name="Mother_Name")
  	  private String MotherName;
	  
	  @Column(name="Spouse_Name")
  	  private String SpouseName;
	  
	  @Column(name="Passport_No",unique=true)
  	  private String PassportNo;
	  
	  @Column(name="Marital_Status")
  	  private String MaritalStatus;
	  
	  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  private EmployeePrimaryInfo primaryinfo;
}
