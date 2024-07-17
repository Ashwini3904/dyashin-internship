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
public class TechnicalSkillDto {
	private String skillType;
    private Integer skillRating;
    private Integer yearsOfExperience;
}
