package com.ds.boot_demo.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;


import com.ds.boot_demo.response.CommonResponse;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_PRIMARY_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_SECONDARY_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_EDUCATIONAL_DETAILS_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_ADDRESS_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_BANK_DETAILS_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_TECHNICAL_SKILLS_SAVED_MESSAGE;
import static com.example.demo.constant.EmployeeConstants.EMPLOYEE_INFO_FETCH_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_EXPERIENCE_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYYE_CONTACT_DETAILS_SAVED_MESSAGE;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ds.boot_demo.service.EmployeeService;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.TechnicalSkillDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.AddressDto;
import com.ds.boot_demo.dto.EducationaDetailsDto;
import com.ds.boot_demo.dto.EducationalDetailsListDto;
//import com.ds.boot_demo.dto.TechnicalSkillDto;
import com.ds.boot_demo.dto.TechnicalSkillListDto;
//import com.ds.boot_demo.dto.EducationaDetailsDto;
//import com.ds.boot_demo.service.EmployeeService;
//import com.ds.boot_demo.service.EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
	
	
	private final EmployeeService employeeService;
	
     @GetMapping("/employee")
     public EmployeePrimaryInfoDto getPrimaryInfo() {
    	 return EmployeePrimaryInfoDto.builder().build();
     }
     
     @GetMapping("/employee/{employeeId}")
 	public ResponseEntity<CommonResponse<EmployeePrimaryInfoDto>> getEmployeeInfo(@PathVariable String employeeId) {
 		log.info("EmployeeController :: getEmployeeInfo");
 		EmployeePrimaryInfoDto employeeInfo = employeeService.getEmployeeInfo(employeeId);
 		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<EmployeePrimaryInfoDto>builder().isError(false)
 				.data(employeeInfo).message(EMPLOYEE_INFO_FETCH_MESSAGE).build());
 	}
     
     @GetMapping("/secondary")
     public EmployeeSecondaryInfoDto getSecondaryInfo() {
    	 return EmployeeSecondaryInfoDto.builder().build();
     }
     @GetMapping("/education")
     public EducationalDetailsListDto getEducationalDetailsList() {
    	 return EducationalDetailsListDto.builder().educationalDetails(Arrays.asList(EducationaDetailsDto.builder().build())).build();
     }
     @GetMapping("/address")
     public AddressListDto getAddressDetailsList() {
    	 return AddressListDto.builder().addresses(Arrays.asList(AddressDto.builder().build())).build();
     }
     
     @GetMapping("/bank")
     public BankDetailsDto getBankDetails() {
    	 return BankDetailsDto.builder().build();
     }

     @GetMapping("/technical")
     public TechnicalSkillListDto getTechnicalDetails() {
    	 return TechnicalSkillListDto.builder().skills(Arrays.asList(TechnicalSkillDto.builder().build())).build();
     }
     @GetMapping("/experience")
     public ExperienceListDto getExperience() {
    	 return ExperienceListDto.builder().experience(Arrays.asList(ExperienceDto.builder().build())).build();
     }
     
     @GetMapping("/contact")
     public ContactListDto getContact() {
    	 return ContactListDto.builder().contacts(Arrays.asList(ContactDto.builder().build())).build();
     }
     
     @PostMapping("/employee")
     public ResponseEntity<CommonResponse<Integer>> saveEmployeePrimaryInfo(@RequestBody EmployeePrimaryInfoDto dto) {
    	 log.info("EmployeeController :: saveEmployeePrimaryInfo");
 		 
    	 Integer employeeId = employeeService.saveEmployeePrimaryInfo(dto);
    	 return ResponseEntity.status(HttpStatus.CREATED)
    			 .body(CommonResponse.<Integer>builder()
    			 .isError(false)
    			 .data(employeeId)
    			 .message(EMPLOYYE_PRIMARY_INFO_SAVED_MESSAGE)
    			 .build());
     }
     @PutMapping("/secondary")
     public ResponseEntity<CommonResponse<Integer>> saveEmployeeSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto){
    	 log.info("EmployeeController :: saveEmployeeSecondaryInfo");
    	 Integer primaryId = employeeService.saveEmployeeSecondaryInfo(dto);
    	 return ResponseEntity.status(HttpStatus.OK)
    			 .body(CommonResponse .<Integer>builder()
    					 .isError(false).data(primaryId)
    					 .message(EMPLOYYE_SECONDARY_INFO_SAVED_MESSAGE)
    			  .build());
     }
     
     @PutMapping("/education")
    	 public ResponseEntity<CommonResponse<Integer>> saveEducationalDetails(@RequestBody EducationalDetailsListDto dto){
    	     log.info("EmployeeController :: saveEducationalDetails");
    	     Integer employeeId = employeeService.saveEducationalDetails(dto);
    	     return ResponseEntity.status(HttpStatus.OK)
        			 .body(CommonResponse .<Integer>builder()
        					 .isError(false).data(employeeId)
        					 .message(EMPLOYYE_EDUCATIONAL_DETAILS_SAVED_MESSAGE)
        			  .build());
    	 }
     
        @PutMapping("/address")
        public ResponseEntity<CommonResponse<Integer>> saveAddresses(@RequestBody AddressListDto dto){
        	log.info("EmployeeController :: saveAddresses");
   	     Integer employeeId = employeeService.saveAddresses(dto);
   	     return ResponseEntity.status(HttpStatus.OK)
       			 .body(CommonResponse .<Integer>builder()
       					 .isError(false).data(employeeId)
       					 .message(EMPLOYYE_ADDRESS_SAVED_MESSAGE)
       			  .build());
        }
        @PutMapping("/bank")
        public ResponseEntity<CommonResponse<Integer>> saveBankDetails(@RequestBody BankDetailsDto dto){
        	log.info("EmployeeController :: saveBankDetails");
        	Integer employeeId = employeeService.saveBankDetails(dto);
        	return ResponseEntity.status(HttpStatus.OK)
        			.body(CommonResponse.<Integer>builder().isError(false)
        					.data(employeeId).message(EMPLOYYE_BANK_DETAILS_SAVED_MESSAGE)
        		     .build());
        			
        }
        @PutMapping("/technical")
        public ResponseEntity<CommonResponse<Integer>> saveTechnicalSkills(@RequestBody TechnicalSkillListDto dto){
        	log.info("EmployeeController :: saveTechnicalSkills");
        	Integer employeeId = employeeService.saveTechnicalSkills(dto);
        	return ResponseEntity.status(HttpStatus.OK)
        			  .body(CommonResponse.<Integer>builder().isError(false)
        					  .data(employeeId).message(EMPLOYYE_TECHNICAL_SKILLS_SAVED_MESSAGE)
        			   .build());
        	
        }
        @PutMapping("/experience")
        public ResponseEntity<CommonResponse<Integer>> saveExperience(@RequestBody ExperienceListDto dto){
        	log.info("EmployeeController :: saveExperience");
        	Integer employeeId = employeeService.saveExperience(dto);
        	return ResponseEntity.status(HttpStatus.OK)
        			  .body(CommonResponse.<Integer>builder().isError(false)
        					  .data(employeeId).message(EMPLOYYE_EXPERIENCE_SAVED_MESSAGE)
        			   .build());
        	
        }
        @PutMapping("/contact")
        public ResponseEntity<CommonResponse<Integer>> saveContact(@RequestBody ContactListDto dto){
        	log.info("EmployeeController :: saveContact");
        	Integer employeeId = employeeService.saveContact(dto);
        	return ResponseEntity.status(HttpStatus.OK)
        			  .body(CommonResponse.<Integer>builder().isError(false)
        					  .data(employeeId).message(EMPLOYYE_CONTACT_DETAILS_SAVED_MESSAGE)
        			   .build());
        	
        }
}
