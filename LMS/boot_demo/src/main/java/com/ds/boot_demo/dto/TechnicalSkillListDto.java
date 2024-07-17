package com.ds.boot_demo.dto;

import java.util.List;

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
public class TechnicalSkillListDto {
    private Integer employeeId;
    private List<TechnicalSkillDto> skills;
}
