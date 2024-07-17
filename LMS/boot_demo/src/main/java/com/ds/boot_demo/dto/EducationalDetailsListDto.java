package com.ds.boot_demo.dto;
import java.util.List;
//import com.ds.boot_demo.dto.EducationaDetailsDto;

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
public class EducationalDetailsListDto {
    private Integer primaryInfoid;
    
    private List<EducationaDetailsDto>educationalDetails;
}
