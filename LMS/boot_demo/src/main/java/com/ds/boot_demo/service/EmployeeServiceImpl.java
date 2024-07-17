package com.ds.boot_demo.service;
import org.springframework.stereotype.Service;
//import java.util.stream.*;
//import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
//import java.util.stream.*;

//import org.springframework.beans.factory.annotation.Autowired;
import com.ds.boot_demo.exception.EmployeeException;
import com.ds.boot_demo.entity.Address;
import com.ds.boot_demo.entity.EducationalDetails;
import com.ds.boot_demo.entity.EmployeePrimaryInfo;
import com.ds.boot_demo.entity.EmployeeSecondayInfo;
import com.ds.boot_demo.entity.Experience;
import com.ds.boot_demo.entity.TechnicalSkill;
import com.ds.boot_demo.entity.BankDetails;
import com.ds.boot_demo.entity.Contact;
import com.ds.boot_demo.dto.EducationalDetailsListDto;
import com.ds.boot_demo.dto.AddressDto;
import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.TechnicalSkillDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.EducationaDetailsDto;
import com.ds.boot_demo.dto.TechnicalSkillListDto;
import com.ds.boot_demo.repository.PrimaryInfoRepository;
import com.ds.boot_demo.util.EmployeeUtil;
//import com.example.demo.dto.AddressDto;
//import com.example.demo.dto.EducationalDetailDto;
//import com.example.demo.dto.TechnicalSkillDto;
//import com.example.demo.dto.EducationalDetailDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
		
		private final PrimaryInfoRepository primaryInfoRepository;
		
		@Override
		public Integer saveEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
		    log.info("EmployeeServiceImpl :: saveEmployeePrimaryInfo");
	
		EmployeePrimaryInfo employeePrimaryInfo = EmployeeUtil.dtoEntity(dto);
		
		EmployeePrimaryInfo savedPrimaryInfo = primaryInfoRepository.save(employeePrimaryInfo);
		return savedPrimaryInfo.getId();
		}
		
		@Override
		public Integer saveEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto) {
			log.info("EmployeeServiceImpl :: saveEmployeeSecondaryInfo");
			
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getPrimaryInfoId());
	
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				EmployeeSecondayInfo secondaryInfo = EmployeeUtil.dtoEntity(dto);
						
				primaryInfo.setSecondaryInfo(secondaryInfo);
				secondaryInfo.setPrimaryinfo(primaryInfo);
				
				return primaryInfoRepository.save(primaryInfo).getId();
			}
			throw new EmployeeException("Employee Primary info not found");
		}
		
		@Override
		public Integer saveEducationalDetails(EducationalDetailsListDto dto) {
			log.info("EmployeeServiceImpl :: saveEducationalDetails");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getPrimaryInfoid());
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				List<EducationalDetails> educations = EmployeeUtil.dtoEntities(dto);
				
				primaryInfo.setEducationDetails(educations);
				educations.stream().forEach(edu -> edu.setPrimaryinfo(primaryInfo));
			    
				return primaryInfoRepository.save(primaryInfo).getId();
			}
			
			throw new EmployeeException("Employee Primary info not found");
		}
		@Override
		public Integer saveAddresses(AddressListDto dto) {
			log.info("EmployeeServiceImpl :: saveAddresses");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getEmployeeId());
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				List<Address> addresses = EmployeeUtil.dtoEntities(dto);
				
				primaryInfo.setAddresses(addresses);
				addresses.stream().forEach(add -> add.setPrimaryInfo(primaryInfo));
				return primaryInfoRepository.save(primaryInfo).getId();
				
			}
			throw new EmployeeException("Employee Primary info not found");
		}
		@Override
		public Integer saveBankDetails(BankDetailsDto dto) {
			log.info("EmployeeServiceImpl :: saveBankDetails");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getEmployeeId());
			if(primaryOptional.isPresent()) {
				
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				BankDetails bankDetails = EmployeeUtil.dtoEntity(dto);			
			    primaryInfo.setBankDetails(bankDetails);
			    bankDetails.setPrimaryInfo(primaryInfo);
			    
			    return primaryInfoRepository.save(primaryInfo).getId();
			}
			throw new EmployeeException("Employee Primary info not found");
		}
		
		@Override
		public Integer saveTechnicalSkills(TechnicalSkillListDto dto) {
			log.info("EmployeeServiceImpl :: saveTechnicalDetails");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getEmployeeId());
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				List<TechnicalSkill>skills = dto.getSkills().stream()
						.map(skill -> TechnicalSkill.builder().skillType(skill.getSkillType())
								.skillRating(skill.getSkillRating()).yearsOfExperience(skill.getYearsOfExperience()).primaryinfos(new ArrayList<>())
						.build()).collect(Collectors.toList());
			
			primaryInfo.setTechnicalSkills(skills);
			skills.forEach(skill -> skill.getPrimaryinfos().add(primaryInfo));
			return primaryInfoRepository.save(primaryInfo).getId();
			
		}
			throw new EmployeeException("Employee Primary info not found");
    }
		@Override
		public Integer saveExperience(ExperienceListDto dto) {
			log.info("EmployeeServiceImpl :: saveExperience");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getEmployeeId());
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				List<Experience> exp = EmployeeUtil.dtoEntities(dto);
				
				primaryInfo.setExperience(exp);
				exp.stream().forEach(add -> add.setPrimaryInfo(primaryInfo));
				return primaryInfoRepository.save(primaryInfo).getId();
				
			}
			throw new EmployeeException("Employee Primary info not found");
		}
		@Override
		public Integer saveContact(ContactListDto dto) {
			log.info("EmployeeServiceImpl :: saveContact");
			Optional<EmployeePrimaryInfo>primaryOptional = primaryInfoRepository.findById(dto.getEmployeeId());
			if(primaryOptional.isPresent()) {
				EmployeePrimaryInfo primaryInfo = primaryOptional.get();
				List<Contact> con = EmployeeUtil.dtoEntities(dto);
				
				primaryInfo.setContacts(con);
				con.stream().forEach(add -> add.setPrimaryInfo(primaryInfo));
				return primaryInfoRepository.save(primaryInfo).getId();
				
			}
			throw new EmployeeException("Employee Primary info not found");
		}
		@Override
		public EmployeePrimaryInfoDto getEmployeeInfo(String employeeId) {
			Optional<EmployeePrimaryInfo> opinfo = primaryInfoRepository.findByemployeeid(employeeId);
			if(opinfo.isPresent()) {
			   EmployeePrimaryInfo info = opinfo.get();
			   return  EmployeePrimaryInfoDto.builder()
					    .employeeid(info.getEmployeeid())
						.employeeName(info.getEmployeeName()).dateOfBirth(info.getDateOfBirth())
						.dateOfJoining(info.getDateOfJoining()).emailId(info.getEmailId()).bloodGroup(info.getBloodGroup())
						.designation(info.getDesignation()).gender(info.getGender()).nationlity(info.getNationlity())
						.employeeStatus(info.getEmployeeStatus())
						
						.secondaryInfo(EmployeeSecondaryInfoDto.builder()
								.PanNo(info.getSecondaryInfo().getPanNo())
						    	.AadharNo(info.getSecondaryInfo().getAadharNo()).FatherName(info.getSecondaryInfo()
						    	.getFatherName()).MotherName(info.getSecondaryInfo().getMotherName()).SpouseName(info.getSecondaryInfo().getSpouseName())
						    	.PassportNo(info.getSecondaryInfo().getPassportNo()).MaritalStatus(info.getSecondaryInfo().getMaritalStatus())
								.build())
						
					    .educations(info.getEducationDetails().stream().map(edu -> EducationaDetailsDto.builder()
					    		.educationType(edu.getEducationType()).yearOfPassing(edu.getYearOfPassing()).percentage(edu.getPercentage())
								.university(edu.getUniversity()).institute(edu.getInstitute())
								.specialization(edu.getSpecialization()).state(edu.getState()).build()).collect(Collectors.toList()))
					    
					    .address(info.getAddresses().stream().map(add -> AddressDto.builder().addressType(add.getAddressType()).city(add.getCity()).doorNo(add.getDoorNo())
								.landmark(add.getLandmark()).locality(add.getLocality()).pincode(add.getPincode()).state(add.getState())
								.street(add.getStreet()).build()).collect(Collectors.toList()))
					    
					    .bankDetails(BankDetailsDto.builder().accountNo(info.getBankDetails().getAccountNo())
					    		.accountType(info.getBankDetails().getAccountType()).bankName(info.getBankDetails().getBankName())
					    		.branch(info.getBankDetails().getBranch()).ifscCode(info.getBankDetails().getIfscCode()).state(info.getBankDetails().getState()).build())
					    
					    .technicalSkills(info.getTechnicalSkills().stream().map(skill -> TechnicalSkillDto.builder()
					    		.skillType(skill.getSkillType())
								.skillRating(skill.getSkillRating()).yearsOfExperience(skill.getYearsOfExperience())
					    		.build()).collect(Collectors.toList()))
					    
					    .experience(info.getExperience().stream().map(e -> ExperienceDto.builder()
					    		.companyName(e.getCompanyName()).dateOfJoining(e.getDateOfJoining()).dateOfRelieving(e.getDateOfRelieving())
								.yearsOfExperience(e.getYearsOfExperience()).designation(e.getDesignation()).location(e.getLocation())
					    		.build()).collect(Collectors.toList()))
					    
					    .contact(info.getContacts().stream().map(c -> ContactDto.builder()
					    		.contactNumber(c.getContactNumber()).contactType(c.getContactType())
					    		.build()).collect(Collectors.toList()))
					    
					   .build();
			   
			}
			throw new EmployeeException("Employee info not found");
		}
}
