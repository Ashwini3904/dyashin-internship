package com.ds.boot_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
	
	private String addressType;
    private String doorNo;
    private String street;
    private String locality;
    private String city;
    private String state;
    private Integer pincode;
    private String landmark;
}
