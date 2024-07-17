package com.ds.boot_demo.entity;
import java.time.LocalDate;
//import com.ds.boot_demo.entity.*;
import java.util.List;
//import com.ds.boot_demo.entity.EmployeeSecondayInfo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private  Integer id;
	  
	  @Column(name="employee_id",unique=true)
      private String employeeid;
	  
	  @Column(name="employee_name")
      private String employeeName;
	  
      @Column(name="date_of_joining")
      private LocalDate dateOfJoining;
	  
	  @Column(name="date_of_birth")
      private LocalDate dateOfBirth;
	  
	  @Column(name="email_id")
      private String emailId;
	  
	  @Column(name="blood_group")
      private String bloodGroup;
	  
	  @Column(name="designation")
      private String designation;
	  
	  @Column(name="gender")
      private String gender;
	  
	  @Column(name="nationality")
      private String nationlity;
	  
	  @Column(name="employee_status")
      private String employeeStatus;
	  
	  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryinfo")
	  private EmployeeSecondayInfo secondaryInfo;
	  
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="primaryinfo")
	  private List<EducationalDetails> educationDetails;
	  
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="primaryInfo")
	  private List<Address> addresses;
	  
	  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryInfo")
	  private BankDetails bankDetails;
	  
	  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryinfos")
	  private List<TechnicalSkill> technicalSkills;
	  
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryInfo")
	  private List<Experience> experience;
	  
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryInfo")
	  private List<Contact> contacts;
}
