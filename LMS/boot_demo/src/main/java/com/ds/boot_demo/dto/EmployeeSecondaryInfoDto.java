package com.ds.boot_demo.dto;

//import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSecondaryInfoDto {
	
	  private Integer primaryInfoId;
	  private String PanNo;
	  private String AadharNo;
	  private String FatherName;
	  private String MotherName;
	  private String SpouseName;
	  private String PassportNo;
	  private String MaritalStatus;
}
