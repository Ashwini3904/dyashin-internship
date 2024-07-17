package com.ds.boot_demo.service;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.EducationalDetailsListDto;
import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.TechnicalSkillListDto;

public interface EmployeeService {
    Integer saveEmployeePrimaryInfo(EmployeePrimaryInfoDto dto);
    
    Integer saveEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto);
    
    Integer saveEducationalDetails(EducationalDetailsListDto dto);
    
    Integer saveAddresses(AddressListDto dto);
    
    Integer saveBankDetails(BankDetailsDto dto);
    
    Integer saveTechnicalSkills(TechnicalSkillListDto dto);

	Integer saveExperience(ExperienceListDto dto);

	Integer saveContact(ContactListDto dto);

	EmployeePrimaryInfoDto getEmployeeInfo(String employeeId);
    
//    EmployeePrimaryInfoDto getEmployeeInfo(String employeeId);
}
