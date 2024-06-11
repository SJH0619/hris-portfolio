package com.portfolio.hris.department;

import lombok.Data;

@Data
public class DepartmentDTO {
    public String departmentCode;
    public String departmentName;
    public String parentDepartmentCode;
    public String departmentManagerUeid;
    public String foundationDate;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
