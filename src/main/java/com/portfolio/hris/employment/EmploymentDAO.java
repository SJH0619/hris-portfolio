package com.portfolio.hris.employment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentDAO {
    private String employmentType;
    private String employmentName;
    private String employmentComment;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static EmploymentDAO applyEmploymentDTO(EmploymentDTO employmentDTO) {
        return EmploymentDAO.builder()
                .employmentType(employmentDTO.getEmploymentType())
                .employmentName(employmentDTO.getEmploymentName())
                .employmentComment(employmentDTO.getEmploymentComment())
                .insertAt(employmentDTO.getInsertAt())
                .insertBy(employmentDTO.getInsertBy())
                .updateAt(employmentDTO.getUpdateAt())
                .updateBy(employmentDTO.getUpdateBy())
                .build();
    }

    public EmploymentDTO getEmploymentDTO() {
        EmploymentDTO employmentDTO = new EmploymentDTO();
        employmentDTO.setEmploymentType(employmentType);
        employmentDTO.setEmploymentName(employmentName);
        employmentDTO.setEmploymentComment(employmentComment);
        employmentDTO.setInsertAt(insertAt);
        employmentDTO.setInsertBy(insertBy);
        employmentDTO.setUpdateAt(updateAt);
        employmentDTO.setUpdateBy(updateBy);

        return employmentDTO;
    }
}
