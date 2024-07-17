package com.ds.boot_demo.entity;

//import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

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
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressType;
    private String doorNo;
    private String street;
    private String locality;
    private String city;
    private String state;
    private Integer pincode;
    private String landmark;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EmployeePrimaryInfo primaryInfo;
}
