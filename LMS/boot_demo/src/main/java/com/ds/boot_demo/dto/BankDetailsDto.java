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
public class BankDetailsDto {
	
	private Integer employeeId;
	private String accountNo;
    private String bankName;
    private String branch;
    private String accountType;
    private String ifscCode;
    private String state;
}
