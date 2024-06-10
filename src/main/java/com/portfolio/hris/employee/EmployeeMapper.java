package com.portfolio.hris.employee;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDAO> getList();

    void createEmployee(EmployeeDAO employeeDAO);
}
