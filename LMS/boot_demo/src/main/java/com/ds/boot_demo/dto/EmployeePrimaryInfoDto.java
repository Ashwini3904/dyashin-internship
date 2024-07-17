package com.ds.boot_demo.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePrimaryInfoDto {
	
    private String employeeid;
    private String employeeName;
    private LocalDate dateOfJoining;
    private LocalDate dateOfBirth;
    private String emailId;
    private String bloodGroup;
    private String designation;
    private String gender;
    private String nationlity;
    private String employeeStatus;
    
    private EmployeeSecondaryInfoDto secondaryInfo;
    private List<EducationaDetailsDto> educations;
    private List<AddressDto> address;
    private BankDetailsDto bankDetails;
    private List<TechnicalSkillDto> technicalSkills;
    private List<ExperienceDto> experience;
    private List<ContactDto> contact;
 }
