package com.ds.boot_demo.util;
import com.ds.boot_demo.entity.Address;
import com.ds.boot_demo.entity.BankDetails;
import com.ds.boot_demo.entity.EducationalDetails;
//import java.util.List;
import com.ds.boot_demo.entity.EmployeePrimaryInfo;
import com.ds.boot_demo.entity.EmployeeSecondayInfo;
import com.ds.boot_demo.entity.Experience;
import com.ds.boot_demo.entity.Contact;
//import com.ds.boot_demo.entity.TechnicalSkill;
//import com.ds.boot_demo.entity.EducationalDetails;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
//import com.ds.boot_demo.dto.TechnicalSkillListDto;
import com.ds.boot_demo.dto.ExperienceListDto;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.EducationalDetailsListDto;
//import com.ds.boot_demo.dto.EducationalDetailsListDto;

public class EmployeeUtil {
	private EmployeeUtil(){
		
	}
	
    public static EmployeePrimaryInfo dtoEntity(EmployeePrimaryInfoDto dto) {
    	return EmployeePrimaryInfo.builder().employeeid(dto.getEmployeeid())
		.employeeName(dto.getEmployeeName()).dateOfBirth(dto.getDateOfBirth())
		.dateOfJoining(dto.getDateOfJoining()).emailId(dto.getEmailId()).bloodGroup(dto.getBloodGroup())
		.designation(dto.getDesignation()).gender(dto.getGender()).nationlity(dto.getNationlity())
		.employeeStatus(dto.getEmployeeStatus()).build();
    }
    public static EmployeeSecondayInfo dtoEntity(EmployeeSecondaryInfoDto dto) {
    	return EmployeeSecondayInfo.builder().PanNo(dto.getPanNo())
    	.AadharNo(dto.getAadharNo()).FatherName(dto.getFatherName()).MotherName(dto.getMotherName())
    	.SpouseName(dto.getSpouseName()).PassportNo(dto.getPassportNo()).MaritalStatus(dto.getMaritalStatus())
		.build();

    }
        public static List<EducationalDetails> dtoEntities(EducationalDetailsListDto dto){
    	return dto.getEducationalDetails().stream()
				.map(edu -> EducationalDetails.builder().educationType(edu.getEducationType())
						.yearOfPassing(edu.getYearOfPassing()).percentage(edu.getPercentage())
						.university(edu.getUniversity()).institute(edu.getInstitute())
						.specialization(edu.getSpecialization()).state(edu.getState())
						.build()).collect(Collectors.toList());
    }
    public static List<Address> dtoEntities(AddressListDto dto){
    	return dto.getAddresses().stream()
				.map(add -> Address.builder().addressType(add.getAddressType()).city(add.getCity()).doorNo(add.getDoorNo())
				.landmark(add.getLandmark()).locality(add.getLocality()).pincode(add.getPincode()).state(add.getState())
				.street(add.getStreet()).build()).collect(Collectors.toList());
    }
    public static BankDetails dtoEntity(BankDetailsDto dto) {
   	 return BankDetails.builder().accountNo(dto.getAccountNo())
		.accountType(dto.getAccountType()).bankName(dto.getBankName())
		.branch(dto.getBranch()).ifscCode(dto.getIfscCode()).state(dto.getState()).build();

   }
//    public static List<TechnicalSkill> dtoEntities(TechnicalSkillListDto dto){
//    	return  dto.getSkills().stream()
//				.map(skill -> TechnicalSkill.builder().skillType(skill.getSkillType())
//						.skillRating(skill.getSkillRating()).yearsOfExperience(skill.getYearsOfExperience()).primaryinfos(new ArrayList<>())
//				.build()).collect(Collectors.toList());
//    }

	public static List<Experience> dtoEntities(ExperienceListDto dto) {
		return dto.getExperience().stream()
				.map(e -> Experience.builder().companyName(e.getCompanyName())
				.dateOfJoining(e.getDateOfJoining()).dateOfRelieving(e.getDateOfRelieving())
				.yearsOfExperience(e.getYearsOfExperience()).designation(e.getDesignation())
				.location(e.getLocation()).build()).collect(Collectors.toList());
	}

	public static List<Contact> dtoEntities(ContactListDto dto) {
		return dto.getContacts().stream()
				.map(c -> Contact.builder().contactNumber(c.getContactNumber())
				.contactType(c.getContactType()).build()).collect(Collectors.toList());
	}

 
}
