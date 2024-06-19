package com.portfolio.hris.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDAO {
    private String departmentCode;
    private String departmentName;
    private String parentDepartmentCode;
    private String departmentManagerUeid;
    private String foundationDate;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static DepartmentDAO applyDepartmentDTO(DepartmentDTO departmentDTO) {
        return DepartmentDAO.builder()
                .departmentCode(departmentDTO.getDepartmentCode())
                .departmentName(departmentDTO.getDepartmentName())
                .parentDepartmentCode(departmentDTO.getParentDepartmentCode())
                .departmentManagerUeid(departmentDTO.getDepartmentManagerUeid())
                .foundationDate(departmentDTO.getFoundationDate())
                .insertAt(departmentDTO.getInsertAt())
                .insertBy(departmentDTO.getInsertBy())
                .updateAt(departmentDTO.getUpdateAt())
                .updateBy(departmentDTO.getUpdateBy())
                .build();
    }

    public DepartmentDTO getDepartmentDTO() {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode(departmentCode);
        departmentDTO.setDepartmentName(departmentName);
        departmentDTO.setParentDepartmentCode(parentDepartmentCode);
        departmentDTO.setDepartmentManagerUeid(departmentManagerUeid);
        departmentDTO.setFoundationDate(foundationDate);
        departmentDTO.setInsertAt(insertAt);
        departmentDTO.setInsertBy(insertBy);
        departmentDTO.setUpdateAt(updateAt);
        departmentDTO.setUpdateBy(updateBy);

        return departmentDTO;
    }
}
