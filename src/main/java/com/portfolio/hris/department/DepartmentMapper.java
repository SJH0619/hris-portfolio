package com.portfolio.hris.department;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<DepartmentDAO> getList();

    void createDepartment(DepartmentDAO departmentDAO);

    DepartmentDAO getDepartmentByDepartmentCode(String departmentCode);
}
