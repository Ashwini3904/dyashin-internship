package com.ds.boot_demo.entity;

import jakarta.persistence.CascadeType;

//import java.time.LocalDate;
//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BankDetails {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;
      private String accountNo;
      private String bankName;
      private String branch;
      private String accountType;
      private String ifscCode;
      private String state;
      @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
      private EmployeePrimaryInfo primaryInfo;
}
