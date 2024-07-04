package com.portfolio.hris.salary.type;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SalaryTypeDAO {
    private String salaryType;
    private String salaryTypeName;
    private String salaryTypeComment;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static SalaryTypeDAO applySalaryTypeDTO(SalaryTypeDTO salaryTypeDTO) {
        return SalaryTypeDAO.builder()
                .salaryType(salaryTypeDTO.getSalaryType())
                .salaryTypeName(salaryTypeDTO.getSalaryTypeName())
                .salaryTypeComment(salaryTypeDTO.getSalaryTypeComment())
                .insertAt(salaryTypeDTO.getInsertAt())
                .insertBy(salaryTypeDTO.getInsertBy())
                .updateAt(salaryTypeDTO.getUpdateAt())
                .updateBy(salaryTypeDTO.getUpdateBy())
                .build();
    }

    public SalaryTypeDTO getSalaryTypeDTO() {
        SalaryTypeDTO salaryTypeDTO = new SalaryTypeDTO();
        salaryTypeDTO.setSalaryType(salaryType);
        salaryTypeDTO.setSalaryTypeName(salaryTypeName);
        salaryTypeDTO.setSalaryTypeComment(salaryTypeComment);
        salaryTypeDTO.setInsertAt(insertAt);
        salaryTypeDTO.setInsertBy(insertBy);
        salaryTypeDTO.setUpdateAt(updateAt);
        salaryTypeDTO.setUpdateBy(updateBy);

        return salaryTypeDTO;
    }
}
