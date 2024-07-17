package com.ds.boot_demo.dto;

import java.util.List;

//import com.ds.boot_demo.entity.Experience;

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
public class ExperienceListDto {
    private Integer employeeId;
    private List<ExperienceDto> experience;
}
